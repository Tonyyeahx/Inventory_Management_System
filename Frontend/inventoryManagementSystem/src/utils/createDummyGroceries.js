/**
 * @file A file to generate dummy groceries for testing frontend designs
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

/**
 * Create a single dummy grocery item
 */
function createDummyGroceryItem (
  inventoryID, storeID, productID, productImg, productName, categoryID, category, cost, sellPrice, 
  quantity, discount, lastOrderedDate, orderedQuantity, supplierID, supplier
) {
  const dummyGroceryItem = {
    "inventoryID": inventoryID, 
    "storeID": storeID,
    "productID": productID,
    "productImg": productImg,
    "productName": productName,
    "categoryID": categoryID, 
    "category": category,
    "cost": cost,
    "sellPrice": sellPrice,
    "quantity": quantity,
    "discount": discount,
    "lastOrderedDate": lastOrderedDate,
    "orderedQuantity": orderedQuantity,
    "supplierID": supplierID,
    "supplier": supplier
  }

  return dummyGroceryItem
}

/**
 * Create a list of dummy grocery items
 */
export default function createDummyGroceries() {
  let dummy1 = createDummyGroceryItem (
    100001,
    12345, 
    "0001", 
    "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Garden_strawberry_%28Fragaria_%C3%97_ananassa%29_single2.jpg/640px-Garden_strawberry_%28Fragaria_%C3%97_ananassa%29_single2.jpg",
    "Fresh Strawberries",
    "0001",
    "Fresh Fruits",
    3.99,
    2.15,
    200,
    0.99,
    "02-01-2024",
    100000,
    "10001",
    "XYZ Farm"
    )

    return [dummy1]
}

