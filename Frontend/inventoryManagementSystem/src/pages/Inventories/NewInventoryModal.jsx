// External imports
import React from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';
import Form from 'react-bootstrap/Form'
function NewInventoryModal(props){
    const { show, handleClose } = props;
    const [selectedImage, setSelectedImage] = useState(null);
    const [category, setCategory] = useState('');
    const [sellPrice, setSellPrice] = useState('');
    const [purchaseCost, setPurchaseCost] = useState('');
    const [supplier, setSupplier] = useState('');
    const [otherSupplier, setOtherSupplier] = useState('');

    // Function to handle image selection
    const handleImageChange = (event) => {
        const imageFile = event.target.files[0];
        setSelectedImage(imageFile);
    };

    // Function to handle form submission
    const handleSubmit = () => {
        // Send selectedImage to backend
        // You can use FormData to send the image along with other form data
        const formData = new FormData();
        formData.append('image', selectedImage);
        // Add other form fields to the formData object as needed

        // Example fetch call to send formData to backend
        fetch('backend/upload/image', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            // Handle response
            console.log(response);
        })
        .catch(error => {
            // Handle error
            console.error('Error:', error);
        });
    };

    const handleSave = () => {
        const inventoryData = {
            category,
            sellPrice,
            purchaseCost,
            supplier: supplier === 'Other Supplier' ? otherSupplier : supplier
        };
        console.log(inventoryData);
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Add New Inventory</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    {/* Product Category dropdown */}
                    <Form.Group className="mb-3">
                        <Form.Label>Product Category</Form.Label>
                        <Form.Control as="select" value={category} onChange={(e) => setCategory(e.target.value)}>
                            <option value="">Select Category</option>
                            <option value="Fresh Fruits">Fresh Fruits</option>
                            <option value="Frozen">Frozen</option>
                            <option value="Chinese Memes">Chinese Memes</option>
                            <option value="Fresh Vegetables">Fresh Vegetables</option>
                        </Form.Control>
                    </Form.Group>

                    {/* Sell Price and Purchase Cost inputs */}
                    <Form.Group className="mb-3">
                        <Form.Label>Sell Price</Form.Label>
                        <Form.Control type="text" placeholder="$0.00" value={sellPrice} onChange={(e) => setSellPrice(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Purchase Cost</Form.Label>
                        <Form.Control type="text" placeholder="$0.00" value={purchaseCost} onChange={(e) => setPurchaseCost(e.target.value)} />
                    </Form.Group>

                    {/* Product Supplier dropdown */}
                    <Form.Group className="mb-3">
                        <Form.Label>Product Supplier</Form.Label>
                        <Form.Control as="select" value={supplier} onChange={(e) => setSupplier(e.target.value)}>
                            <option value="">Select Supplier</option>
                            <option value="XYZ Farm">XYZ Farm</option>
                            <option value="ABC Warehouse">ABC Warehouse</option>
                            <option value="iKun Warehouse">iKun Warehouse</option>
                            <option value="SHENG DI YA GE">SHENG DI YA GE</option>
                            <option value="Other Supplier">Other Supplier</option>
                        </Form.Control>
                        {supplier === 'Other Supplier' &&
                            <Form.Control type="text" placeholder="Enter Supplier Name" value={otherSupplier} onChange={(e) => setOtherSupplier(e.target.value)} />
                        }
                    </Form.Group>
                </Form>
                <Button variant="secondary" onClick={handleClose}>Cancel</Button>
                <Button variant="primary" onClick={handleSave}>Save Inventory</Button>
            </Modal.Body>
        </Modal>

    );
}

export default NewInventoryModal;