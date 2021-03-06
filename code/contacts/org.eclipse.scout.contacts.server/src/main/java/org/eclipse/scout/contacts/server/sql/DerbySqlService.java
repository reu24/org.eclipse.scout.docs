/*
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 */
package org.eclipse.scout.contacts.server.sql;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.scout.contacts.server.sql.DatabaseProperties.DatabaseAutoCreateProperty;
import org.eclipse.scout.contacts.server.sql.DatabaseProperties.JdbcMappingNameProperty;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.exception.PlatformExceptionTranslator;
import org.eclipse.scout.rt.server.jdbc.derby.AbstractDerbySqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Order(1950)
// tag::service[]
public class DerbySqlService extends AbstractDerbySqlService {
  private static final Logger LOG = LoggerFactory.getLogger(DerbySqlService.class);

  @Override
  protected String getConfiguredJdbcMappingName() {
    String mappingName = CONFIG.getPropertyValue(JdbcMappingNameProperty.class);

    // add create attribute if we need to autocreate the db
    if (CONFIG.getPropertyValue(DatabaseAutoCreateProperty.class)) {
      return mappingName + ";create=true"; // <1>
    }

    return mappingName;
  }
  // end::service[]

  public void dropDB() {
    try {
      String jdbcMappingName = CONFIG.getPropertyValue(JdbcMappingNameProperty.class);
      DriverManager.getConnection(jdbcMappingName + ";drop=true");
    }
    catch (SQLException e) {
      //noinspection ThrowableNotThrown
      BEANS.get(PlatformExceptionTranslator.class).translate(e);
    }
  }

  @Override
  public void destroy() {
    try {
      // Shutdown derby
      // Expects the property scout.sql.jdbc.driverUnload to be set to false,
      // otherwise super.destroy() will throw an exception
      DriverManager.getConnection("jdbc:derby:;shutdown=true");
    }
    catch (SQLException e) {
      if ("XJ015".equals(e.getSQLState())) {
        // expected error on shutdown -> ignore
      }
      else {
        LOG.warn("Exception while shutting down derby", e);
      }
    }
    super.destroy();
  }

  // tag::service[]
}
// end::service[]
