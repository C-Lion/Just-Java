/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 98;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText customer_Name = (EditText) findViewById(R.id.customer_name_field);
        String getCustomerName = customer_Name.getText().toString();
        //Log.v("MainActivity", "Name: " + getCustomerName);

        //Check to see if the user wants whipped cream topping
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        //Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);

        //Check to see if the user wants whipped chocolate
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean addChocolate = chocolateCheckbox.isChecked();
        Log.v("MainActivity", "Has chocolate: " + addChocolate);

        // Calculate the price based on the above info and display full message to app screeen
        int price = calculatePrice(hasWhippedCream, addChocolate);
        //Log.v("MainActivity", "The price is " + price);
        String priceMessage = createOrderSummary(getCustomerName, price, hasWhippedCream, addChocolate);
        displayMessage(priceMessage);

        //ensure that your intent is handled only by an email app

    }

    /**
     *Calculates the price of the order.
     *
     * @return total price
     * @param hasWhippedCream
     * @param addChocolate
     */
    private int calculatePrice(boolean hasWhippedCream, boolean addChocolate){
        //Price of 1 cup of coffee
        int basePrice = 5;

        //Add $1 if the user wants to add whipped cream
        if (hasWhippedCream) {
            basePrice += 1;
        }
        //Add $2 if the user wants to add chocolate
        if (addChocolate) {
            basePrice += 2;
        }

        //Calculate the total price of 1 cup of coffee with requested toppings
        return quantity * basePrice;
    }

    /**
     *Concatenates a text summary of the order.
     *
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate added
     * @return Text string summary of customer name, quantity ordered, total price and thank you!
     */
    private String createOrderSummary(String getCustomerName, int price, boolean addWhippedCream, boolean addChocolate){
        String checkoutMessage = "Name: " + getCustomerName;
        checkoutMessage += "\nAdd whipped cream? " + addWhippedCream;
        checkoutMessage += "\nAdd chocolate? " + addChocolate;
        checkoutMessage += "\nQuantity: " + quantity;
        checkoutMessage += "\nTotal: $" + price;
        checkoutMessage += "\nThank you and have a nice day!";
        return checkoutMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int cups) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + cups);
    }

    /**
     * This method used to display the given price on the screen.
     * THIS METHOD IS NO LONGER USED SINCE CREATING THE DISPLAY MESSAGE METHOD.
     * IT CAN BE DELETED NOW.
     *
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    */

    /**
     * This method is called when the + (plus) button is clicked.
     * This method will soon increment the counter for the number of cups of coffee ordered.
     */
    public void increment(View view) {
        if (quantity == 100) {
            //Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method since there is nothing left to do
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * * This method is called when the - (minus) button is clicked.
     * This method will SOON decrement the counter for the number of cups of coffee ordered.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot less than one coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early as there is nothing left to do
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}