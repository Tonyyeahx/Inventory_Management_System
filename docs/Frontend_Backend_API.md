# HTTP API Request for Frontend-Backend Communication

## Merchant View

### Inventories

Request the inventories of a certain store, with possible category and supplier constraint filters. This HTTP method will be used to display inventories of a given store in the `Inventories` tab of the merchant view on the frontend.

| Method  |      URL       |             Parameters          |
| ------- | -------------  | ------------------------------- |
|  `GET`  | `/inventories` | `store`, `category`, `supplier` |


#### Remarks

None. All users with or without authentications should be able to call this HTTP method


#### Example Calls

1. Show all inventories from store with ID `123`, with no constraint filters on category or supplier

    `/inventories?store=123&category&supplier`

2. Show `Fruits` inventories at store `123` from all supplier

    `/inventories?store=123&category=Fruits&supplier`

3. Show `Chicken` inventories at store `123` from `iKun Warehouse`

    `/inventories?store=123&category=Chicken&supplier=iKun%20Warehouse`


#### Expect Returns

A list of inventories in the store, with given filter condition applied, in JSON format. 

For example:

1. Successful call, return a list of inventory objects, with a return code `200` (OK)

    ```
    [
        {
            "inventoryID": 100001,
            "storeID": 12345,
            "productID": 23456,
            "productImg": "/assets/item_001.png"
            "productName": "Beautiful Chicken",
            "categoryID": 996007,
            "category": "Chicken",
            "cost": 2.50, 
            "sellPrice": 2.75,
            "quantity": 2500,
            "discount": 0.0,
            "lastOrderedDate": "2024-03-05",
            "orderedQuantity": 10000,
            "supplierID:": 12345,
            "supplier": "iKun Warehouse"
        }, 
        {
            "inventoryID": 100002,
            "storeID": 12345,
            "productID": 23456,
            "productImg": "/assets/item_001.png"
            "productName": "Beautiful iKun",
            "categoryID": 9960078,
            "category": "Chicken",
            "cost": 2.50, 
            "sellPrice": 2.75,
            "quantity": 2500,
            "discount": 0.0,
            "lastOrderedDate": "2024-03-05",
            "orderedQuantity": 10000,
            "supplierID:": 12345,
            "supplier": "iKun Warehouse" 
        },
        ...
    ]
    ```

2. Successful call but there is no inventory matching given constrains, return an empty array, with a return code `200` (OK)

    ```
    []
    ```

3. Unsuccessful call due to wrong argument given (e.g. non-existing storeID, category, or supplier), return a message object with descriptive error message, using return code `400` (Bad Request)

    ```
    {
        "msg": "Illegal store ID"
    }
    ```


### Set Inventory Quantity (Merchant Only)

Set the quantity of a certain inventory in a given store to a target number. This HTTP method will be used to increment and decrement quantity of a certain inventory by the merchant.

| Method  |      URL       |             Parameters          |
| ------- | -------------  | ------------------------------- |
| `POST`  | `/setInventoryQuantity` | `inventoryID`, `targetQuantity` |


#### Remarks

Due to security reasons, only merchant users (including store manager and higher level management team members. User authentications will be implemented in a later phase) should be able to call this API.

User authentication function will not be implemented during Sprint 1, so the base case backend does not need to consider user authentication for now. However, the backend should be designed with user authentication function in mind to streamline future developments


#### Example Calls

1. Set product with ID `10001`'s quantity to `999`

    `/setInventoryQuantity?inventoryID=10001&targetQuantity=999`

2. Set product with ID `10002`'s quantity to `0`

    `/setInventoryQuantity?inventoryID=10002&targetQuantity=0`

3. Set product with ID `10003`'s quantity to `-1` (illegal)

    `/setInventoryQuantity?inventoryID=10003&targetQuantity=-1`

4. Set product with ID `10003`'s quantity to `abcd` (illegal)

    `/setInventoryQuantity?inventoryID=10003&targetQuantity=abcd`

#### Expect Returns

A message object with descriptive message indicating whether or not this operation is successful, or an descriptive error message when operation is illegal

For example: 

1. Successful call, return a message object indicting operation is successful with a return code `200` (OK)

    ```
    {
        "msg": "Target quantity set successful"
    }
    ```

2. Unsuccessful call due to a illegal input argument (ex. a negative number or even not a number), return an error message with a return code `400` (Bad Request)

    ```
    {
        "msg": "Illegal targetQuantity input"
    }
    ```

3. Unsuccessful call due to unauthorized user (i.e. a customer or a consumer), return an error message with a return code `401` (Unauthorized)

    ```
    {
        "msg": "Unauthorized user"
    }
    ```


## Consumer View