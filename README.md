## C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.

Files: 

src/main/resources/templates/mainscreen.html (lines 14-53)

Change: 

Added shop name to main screen HTML page, added product name and names of parts.

## D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

Files: 

src/main/java/com/example/demo/controllers/ShopController.java (every line is new)

src/main/resources/templates/about.html (every line is new)

src/main/resources/templates/mainscreen.html , (line 20)

Change: 

Added an "about page" nav, that takes back to main screen as well. About page describes information about the shop.

## E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

Files:

src/main/java/com/example/demo/controllers/MainScreenControllerr.java (just lines on added some debug print statements)

src/main/java/com/example/demo/service/InventoryService.java, (every line is new)

Change: 

Added a sample inventory to be added when the mainscreen is routed to, only adding it when the parts and products lists are empty. Checking for duplicates, creating a multipack part.

## F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

Files:

pom.xml, lines (57-60)

src/main/java/com/example/demo/controllers/AddProductController.java (lines 116-132)

src/main/java/com/example/demo/domain/InhousePart.java, (lines 20-26)

src/main/java/com/example/demo/service/InventoryService.java, (lines 5-71)

src/main/resources/templates/mainscreen.html, (lines 17-99)

Change: 

Added "buyproduct" function to product controller, decreasing inventory of that product by 1 each time. Changed model of inhouse part and reflected those changes in inventory service when sample inventory is added.

In Mainscreen, added success and error messages when buying product, then added the buy button next to update and delete buttons.

## G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

Files:

src/main/java/com/example/demo/controllers/AddInhousePartController.java (lines 49-56)

src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java (lines 50-58)

src/main/resources/templates/InhousePartForm.html (lines 24-32)

src/main/resources/templates/OutsourcedPartForm.html (lines 24-32)

src/main/resources/application.properties (line 6)

Change: 

Added restraints in submit form of inhouse and outsourced part controller, to check if changed inventory is in bounds of max and min inventory.

Added min and max inventory to Part model.

Added input fields to appropriate form templates.

Changed controller code to enforce that inventory updated or set is between min and max bounds, added error message too.

## H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

Files:

src/main/java/com/example/demo/controllers/AddProductController.java (lines 93-111)

src/main/resources/templates/productForm.html (lines 28-30)

Change: Added error messages and validation whenever adding products or updating, if it decreases associated part count below minimum.

Added error message to productForm.html to display errors.

Displaying error messages for low and max inventory for the parts was addressed in part G.

## I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

Files:

src/test/java/com/example/demo/domain/PartTest.java (lines 114-144)

Change: 

Added junit tests for 4 things, (getMinInv, setMinInv, getMaxInv, setMaxInv)

## J.  Remove the class files for any unused validators in order to clean your code.

Didn't change anything here because I see that all class items are utilized.
