/**
 * @file A single row of the inventories table.
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useContext} from 'react'
import { BsPencilSquare, BsTrash } from 'react-icons/bs';

// Context imports
import ViewModeContext from '../../context/ViewModeContext';

function InventoriesTableRow(props) {
  // Toggles between 'View' and 'Edit'
  const [viewEditMode, setViewEditMode] = useContext(ViewModeContext)

  // Function to handle click on delete icon
  const handleDeleteClick = (event) => {
    event.stopPropagation(); // Prevent row click event from firing
    // Add your delete logic here
    console.log('Delete clicked for ', props.productName);
  };
  

  return (
    <tr onClick={() => props.openProductDetailModal(props)}> 
      <td>{props.productName}</td>
      <td>{props.category}</td>
      <td>${props.sellPrice.toFixed(2)}</td>
      <td>${props.cost.toFixed(2)}</td>
      <td>${props.discount.toFixed(2)}</td>
      <td>{props.quantity} / {props.orderedQuantity}</td>
      <td>{props.lastOrderedDate}</td>
      <td>{props.supplier}</td>

      {/* Render delete and edit icons if in Edit mode */}
        {viewEditMode === 'Edit' && (
        <td>
          <BsPencilSquare />
          <div onClick={handleDeleteClick}>
            <BsTrash />
          </div>
        </td>
      )}
    </tr>
  )
}

export default InventoriesTableRow
