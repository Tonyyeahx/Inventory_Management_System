/**
 * @file The inventories table shows all inventories matching filter conditions (store, category, 
 *    supplier)
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'
import Table from 'react-bootstrap/Table';

// CSS imports
import "../../App.css"

function InventoriesTable() {
  return (
    <Table bordered hover>
      {/* Table header */}
      <thead>
        <tr> 
          <th>Name</th>
          <th>Category</th>
          <th>Price</th>
          <th>Cost</th>
          <th>Discount</th>
          <th>Quantity</th>
          <th>Last Ordered</th>
          <th>Supplier</th>
        </tr>
      </thead>

      {/* Table body, with placeholder entries now, will be populated with map() and components */}
      <tbody>
      <tr> 
          <td>Fresh Strawberries</td>
          <td>Fresh Fruits</td>
          <td>$3.99</td>
          <td>$2.15</td>
          <td>$0.99</td>
          <td>200</td>
          <td>02-01-2024</td>
          <td>XYZ Farm</td>
        </tr>
        <tr> 
          <td>Fried Chicken Tenders</td>
          <td>Frozen</td>
          <td>$2.50</td>
          <td>$1.00</td>
          <td>$0.00</td>
          <td>114514</td>
          <td>02-15-2024</td>
          <td>iKun Warehouse</td>
        </tr>
        <tr> 
          <td>Fried Basketball</td>
          <td>Chinese Memes</td>
          <td>$2.50</td>
          <td>$1.00</td>
          <td>$0.00</td>
          <td>151085</td>
          <td>02-15-2024</td>
          <td>iKun Warehouse</td>
        </tr>
        <tr> 
          <td>Jin Ke La</td>
          <td>Chinese Memes</td>
          <td>$18.00</td>
          <td>$10.00</td>
          <td>$0.00</td>
          <td>1800</td>
          <td>02-15-2024</td>
          <td>Bilibili</td>
        </tr>
      </tbody>
    </Table>
  );

}

export default InventoriesTable