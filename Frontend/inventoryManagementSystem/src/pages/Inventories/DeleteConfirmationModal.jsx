// External imports
import React from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';

function DeleteConfirmationModal(props) {
  const { productName, show, handleClose, handleConfirmation } = props;

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Confirm Delete</Modal.Title>
      </Modal.Header>
      <Modal.Body>Are you sure you want to delete {productName}?</Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={() => handleConfirmation(false)}>No</Button>
        <Button variant="primary" onClick={() => handleConfirmation(true)}>Yes</Button>
      </Modal.Footer>
    </Modal>
  );
}

export default DeleteConfirmationModal;
