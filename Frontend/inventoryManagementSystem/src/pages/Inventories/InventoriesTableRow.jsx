/**
 * @file A single row of the inventories table.
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'

function InventoriesTableRow(props) {
  return (
    <tr> 
      <td>{props.productName}</td>
      <td>{props.category}</td>
      <td>${props.sellPrice.toFixed(2)}</td>
      <td>${props.cost.toFixed(2)}</td>
      <td>${props.discount.toFixed(2)}</td>
      <td>{props.quantity}</td>
      <td>{props.lastOrderedDate}</td>
      <td>{props.supplier}</td>
    </tr>
  )
}

export default InventoriesTableRow
