/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Graham Smith
 */
public class EditableTableCell<S extends Object, T extends String> extends AbstractEditableTableCell<S, T> {
    public EditableTableCell() {
    }
    @Override
    protected String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
    @Override
    protected void commitHelper( boolean losingFocus ) {
        commitEdit(((T) textField.getText()));
    }
     
}