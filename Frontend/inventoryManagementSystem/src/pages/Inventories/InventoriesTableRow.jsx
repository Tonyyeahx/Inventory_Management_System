/**
 * @file A single row of the inventories table.
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useContext} from 'react'
import { BsPencilSquare, BsTrash } from 'react-icons/bs';

// Context imports
import ViewModeContext from '../../context/ViewModeContext';
import { useState } from 'react';
// Internal imports
import DeleteConfirmationModal from './DeleteConfirmationModal'; // Import the DeleteConfirmationModal component
import ProductDetailModal from './ProductDetailModal';
import { Alert } from 'react-bootstrap';

// CSS imports
import "./InventoriesTableRow.css"

function InventoriesTableRow(props) {
  // Toggles between 'View' and 'Edit'
  const {entry, openProductDetailModal, mode, onDelete} = props;
  const [viewEditMode, setViewEditMode] = useContext(ViewModeContext)
  const [showDeleteConfirmation, setShowDeleteConfirmation] = useState(false);

  // Function to handle click on delete icon
  const handleDeleteClick = (event) => {
    event.stopPropagation(); // Prevent row click event from firing
    // Add your delete logic here
    setShowDeleteConfirmation(true); // Show the delete confirmation modal
  };

  // Function to handle confirmation of delete action
  const handleDeleteConfirmation = (confirmed) => {
    if (confirmed) {
      onDelete(props.inventoryID); // Call the onDelete function with the inventoryID
    }
    setShowDeleteConfirmation(false); // Close the delete confirmation modal
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
        <td >
          <div className="action-col">
            <BsPencilSquare />
            <BsTrash onClick={handleDeleteClick}/>
          </div>
        </td>
      )}
      
      {/* Render DeleteConfirmationModal */}
      {showDeleteConfirmation && (
        <DeleteConfirmationModal
          productName={props.productName}
          show={showDeleteConfirmation}
          handleClose={() => setShowDeleteConfirmation(false)}
          handleConfirmation={handleDeleteConfirmation}
        />
      )}

    </tr>
  )
}

export default InventoriesTableRow
