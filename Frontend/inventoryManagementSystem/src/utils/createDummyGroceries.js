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

  let dummy2 = createDummyGroceryItem (
    100002,
    12345, 
    "0002", 
    "https://www.allrecipes.com/thmb/smc8F-SohMO5r1TaufxlkrULXjo=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/273852-EasyBakedChikenTenders-3X2-0354-1c36a6289fac49ac8dba9c598602116a.jpg",
    "Fried Chicken Tenders",
    "0002",
    "Frozen",
    2.50,
    1.00,
    114514,
    0.00,
    "02-15-2024",
    100000,
    "10002",
    "iKun Warehouse"
  )

  let dummy3 = createDummyGroceryItem (
    100003,
    12345, 
    "0003", 
    "https://picx.zhimg.com/v2-fc5578366035699c2984d83ffd16ccf0_720w.jpg?source=172ae18b",
    "Fried Basketball",
    "0003",
    "Chinese Memes",
    2.50,
    1.00,
    151085,
    0.00,
    "02-15-2024",
    100000,
    "10002",
    "iKun Warehouse"
  )

  let dummy4 = createDummyGroceryItem (
    100004,
    12345, 
    "0004", 
    "https://img1.mydrivers.com/img/20220606/5df81744-df3b-4f38-bb4a-bc4b6b35c6a2.png",
    "Jin Ke La",
    "0003",
    "Chinese Memes",
    18.00,
    10.00,
    1800,
    0.00,
    "02-15-2024",
    100000,
    "10003",
    "SHENG DI YA GE"
  )

  return [dummy1, dummy2, dummy3, dummy4]
}

