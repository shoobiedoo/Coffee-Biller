package com.example.android.intentify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    boolean j, k;
   final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
   final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
   final EditText mEditText = (EditText) findViewById(R.id.edit);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkBox1.isChecked()) {
            checkBox1.setChecked(false);
        }
        if (checkBox2.isChecked()) {
            checkBox2.setChecked(false);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {

        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    public void submitPlus(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price;
        if (checkBox1.isChecked()) {
            price = quantity * (5 + 20);
        }
        if (checkBox2.isChecked()) {
            price = quantity * (5 + 10);
        } else {


            price = quantity * 5;}

        return price;
    }

    private String createOrderSummary(int price) {
        String name = String.valueOf(mEditText.getText());
        k = checkBox1.isChecked();
        j = checkBox2.isChecked();
        String message = "Name:" + name + "\nQuantity" + quantity +"\nadd whipped cream?"+k+ "\nadd chocolate topping?"+j+" \nthe total is $" + price + "\nthanks for choosing us ";
        return message;
    }

    public void submitMinus(View view) {
        quantity--;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}