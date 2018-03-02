/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {


he
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int basePrice = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(name,basePrice, hasWhippedCream, hasChocolate));
    }

    /**
     * Calculates the price of the total price
     * @return the total price
     */
    public int calculatePrice(boolean addWhippedCream,boolean addChocolateCream){
        int basePrice =5;

        if (addWhippedCream){
            basePrice = basePrice+1;
        }

        if (addChocolateCream){
            basePrice = basePrice+2;
        }

        return quantity*basePrice;
    }

    public void increment(View view) {
        if (quantity==100) {
            //show an error message as a toast
            Toast.makeText(this, "You cannot more than 100 coffee",Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity==1) {
            //show an error message as a toast
            Toast.makeText(this, "You cannot less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
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
     * *create summary of the order
     * @param basePrice of the order
     * @return price message
     */

    private String createOrderSummary(String name, int basePrice,boolean hasWhippedCream, boolean hasChocolate){
        String priceMessage = "Name:" + name;
        priceMessage += "\nAdd whipped Cream?"+ hasWhippedCream;
        priceMessage += "\nHas Chocolate?"+ hasChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal:"+ "$"+ basePrice;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}