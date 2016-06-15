package org.eclipse.scout.contacts.shared.organization;

import javax.annotation.Generated;

import org.eclipse.scout.contacts.shared.common.AbstractAddressBoxData;
import org.eclipse.scout.contacts.shared.common.AbstractEmailFieldData;
import org.eclipse.scout.contacts.shared.common.AbstractNotesBoxData;
import org.eclipse.scout.contacts.shared.common.AbstractUrlImageFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.properties.AbstractPropertyData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@Generated(value = "org.eclipse.scout.contacts.client.organization.OrganizationForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class OrganizationFormData extends AbstractFormData {

  private static final long serialVersionUID = 1L;

  public AddressBox getAddressBox() {
    return getFieldByClass(AddressBox.class);
  }

  public Email getEmail() {
    return getFieldByClass(Email.class);
  }

  public Homepage getHomepage() {
    return getFieldByClass(Homepage.class);
  }

  public Name getName() {
    return getFieldByClass(Name.class);
  }

  public NotesBox getNotesBox() {
    return getFieldByClass(NotesBox.class);
  }

  /**
   * access method for property OrganizationId.
   */
  public String getOrganizationId() {
    return getOrganizationIdProperty().getValue();
  }

  /**
   * access method for property OrganizationId.
   */
  public void setOrganizationId(String organizationId) {
    getOrganizationIdProperty().setValue(organizationId);
  }

  public OrganizationIdProperty getOrganizationIdProperty() {
    return getPropertyByClass(OrganizationIdProperty.class);
  }

  public Phone getPhone() {
    return getFieldByClass(Phone.class);
  }

  public Picture getPicture() {
    return getFieldByClass(Picture.class);
  }

  public static class AddressBox extends AbstractAddressBoxData {

    private static final long serialVersionUID = 1L;
  }

  public static class Email extends AbstractEmailFieldData {

    private static final long serialVersionUID = 1L;
  }

  public static class Homepage extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;
  }

  public static class Name extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;
  }

  public static class NotesBox extends AbstractNotesBoxData {

    private static final long serialVersionUID = 1L;
  }

  public static class OrganizationIdProperty extends AbstractPropertyData<String> {

    private static final long serialVersionUID = 1L;
  }

  public static class Phone extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;
  }

  public static class Picture extends AbstractUrlImageFieldData {

    private static final long serialVersionUID = 1L;
  }
}