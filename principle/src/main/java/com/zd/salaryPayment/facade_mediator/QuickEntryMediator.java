package com.zd.salaryPayment.facade_mediator;

import javax.jws.Oneway;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 中介者模式
 * 用JList、JTextField构造了一个QuickEntryMediator类实例，QuickEntryMediator向JTextField注册了一个匿名的
 * DocumentListener，当发生变化时，这个listener就调用textFieldChanged方法
 * Created by ZD on 2017/10/23.
 */
public class QuickEntryMediator {

    private JTextField itsTextField;
    private JList itsList;

    public QuickEntryMediator(JTextField t,JList l){
        itsTextField = t;
        itsList = l;
        itsTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                textFieldChanged();
            }

            public void removeUpdate(DocumentEvent e) {
                textFieldChanged();
            }

            public void changedUpdate(DocumentEvent e) {
                textFieldChanged();
            }
        });
    }

    private void textFieldChanged() {
        String prefix = itsTextField.getText();
        if (prefix.length()==0){
            itsList.clearSelection();
            return;
        }
        ListModel m = itsList.getModel();
        boolean found = false;
        for (int i = 0; found == false && i < m.getSize();i++ ){
            Object o = m.getElementAt(i);
            String s= o.toString();
            if (s.startsWith(prefix)){
                itsList.setSelectedValue(0,true);
                found = true;
            }
        }
        if (!found){
            itsList.clearSelection();
        }
    }


}
