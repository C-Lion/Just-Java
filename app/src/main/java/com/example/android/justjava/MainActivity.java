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
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    /**
     *Concatenates a text summary of the order.
     *
     * @param price of the order
     * @return Text string summary of customer name, quantity ordered, total price and thank you!
     */
    private String createOrderSummary(int price){
        String checkoutMessage = "Name: Kaptain Kunal";
        checkoutMessage += "\nQuantity: " + quantity;
        checkoutMessage += "\nTotal: $" + price;
        checkoutMessage += "\nThank you and have a nice day!";
        //String checkoutMessage = customerName + "\n" + totalItems + "\n" + totalPrice + "\n" + thankYou;
        return checkoutMessage;
    }

    /**
     *Calculates the price of the order.
     *
     * @return total order price
     */
    private int calculatePrice(){
        return quantity * 5;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int cups) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + cups);
    }

    /**
     * This method displays the given price on the screen.
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
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * * This method is called when the - (minus) button is clicked.
     * This method will SOON decrement the counter for the number of cups of coffee ordered.
     */
    public void decrement(View view) {
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