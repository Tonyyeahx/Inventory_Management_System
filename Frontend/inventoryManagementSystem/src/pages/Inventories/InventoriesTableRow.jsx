/**
 * @file A single row of the inventories table.
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React from 'react'
import { BsPencilSquare, BsTrash } from 'react-icons/bs';
import { useState } from 'react';
// Internal imports
import DeleteConfirmationModal from './DeleteConfirmationModal'; // Import the DeleteConfirmationModal component
import ProductDetailModal from './ProductDetailModal';
import { Alert } from 'react-bootstrap';


function InventoriesTableRow(props) {
  const { entry, openProductDetailModal, mode, onDelete } = props;
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
    <tr> 
      <td onClick={() => props.openProductDetailModal(props)}>{props.productName}</td>
      <td onClick={() => props.openProductDetailModal(props)}>{props.category}</td>
      <td onClick={() => props.openProductDetailModal(props)}>${props.sellPrice.toFixed(2)}</td>
      <td onClick={() => props.openProductDetailModal(props)}>${props.cost.toFixed(2)}</td>
      <td onClick={() => props.openProductDetailModal(props)}>${props.discount.toFixed(2)}</td>
      <td onClick={() => props.openProductDetailModal(props)}>{props.quantity} / {props.orderedQuantity}</td>
      <td onClick={() => props.openProductDetailModal(props)}>{props.lastOrderedDate}</td>
      <td onClick={() => props.openProductDetailModal(props)}>{props.supplier}</td>
      {/* Render delete and edit icons if in Edit mode */}
        {mode === 'Edit' && (
        <td>
          <BsPencilSquare />
          <div onClick={handleDeleteClick}>
            <BsTrash />
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
