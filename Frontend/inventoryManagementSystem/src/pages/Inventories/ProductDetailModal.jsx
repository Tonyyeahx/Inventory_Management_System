/**
 * @file A pop-up modal for showing the product detail
 * @author Yucheng Zang <yzang7@wisc.edu>
 */

// External imports
import React, {useState} from 'react'
import Modal from 'react-bootstrap/Modal';

function ProductDetailModal(props) {
  
  const [show, setShow] = useState(true);
  const handleClose = () => setShow(false);

  return (
    <Modal show={props.show} onHide={props.handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Modal heading</Modal.Title>
      </Modal.Header>

      <Modal.Body>
        Woohoo, you are reading this text in a modal!
      </Modal.Body>

    </Modal>
  )
}

export default ProductDetailModal