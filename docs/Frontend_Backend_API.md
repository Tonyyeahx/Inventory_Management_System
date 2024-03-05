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


#### Expect Return Value
A list of inventories in the store, with given filter condition applied, in JSON format. 

For example:

1. Successful call, return a list of inventory objects, with return code = `200` (OK)

    ```
    [
        {
            "inventoryID": 100001,
            "storeID": 12345,
            "productID": 23456,
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

2. Successful call but there is no inventory matching given constrains, return an empty array, with return code = `200` (OK)

    ```
    []
    ```

3. Unsuccessful call due to wrong argument given (e.g. non-existing storeID, category, or supplier), return a message object with descriptive error message, using return code `400` (Bad Request)

    ```
    {
        "msg": "illegal store ID"
    }
    ```

### Set Inventory Quantity

Set the quantity of a certain inventory in a given store. This HTTP method will be used to increment and decrement 



?company=SocksTalk&amn=-10086

