// External imports
import React from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Spinner from 'react-bootstrap/Spinner';

function NewInventoryModal(props){
    const { show, handleClose } = props;
    const [selectedImage, setSelectedImage] = useState(null);
    const [category, setCategory] = useState('');
    const [sellPrice, setSellPrice] = useState('');
    const [purchaseCost, setPurchaseCost] = useState('');
    const [supplier, setSupplier] = useState('');
    const [otherSupplier, setOtherSupplier] = useState('');
    const [productID, setProductID] = useState('');
    const [productName, setProductName] = useState('');
    const [inventoryID, setInventoryID] = useState('');
    const [storeID, setStoreID] = useState('');
    const [categoryID, setCategoryID] = useState('');
    const [supplierID, setSupplierID] = useState('');
    const [discount, setDiscount] = useState('');
    const [quantity, setQuantity] = useState('');
    const [lastOrderedDate, setLastOrderedDate] = useState('');

    // A flag indicating if the submitting is in progress. True when submitting, false when not.
    const [isSubmitting, setIsSubmitting] = useState(false)

    // State variable for validation errors
    const [validationError, setValidationError] = useState('');

    // Function to handle image selection
    const handleImageChange = (event) => {
        const imageFile = event.target.files[0];
        setSelectedImage(imageFile);
    };

    // A function use to submit the change to the server, also will close this modal and refresh the
    // inventory table to reflect the change
    const handleSubmit = () => {

        // Validate form fields
        if (!category || !productName || !quantity || !sellPrice || !purchaseCost || !supplier) {
            setValidationError('All fields are required.');
            return;
        }

        // Set isSubmitting to true to disable the controls and display the uploading animation
        setIsSubmitting(true)

        // TODO: API communication goes here

        // Send a alert to notify the user that submitting is done
        alert("Change submitted")
        setIsSubmitting(false)
        setValidationError('');

        // Reset all state variables to clear the form
        setSelectedImage(null);
        setCategory('');
        setSellPrice('');
        setPurchaseCost('');
        setSupplier('');
        setOtherSupplier('');
        setProductName('');
        setDiscount('');
        setQuantity('');
        setLastOrderedDate('');

        // Close the model and fetch the new inventory table from the server
        props.fetchInventories()
        props.handleClose()
    }


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
                        <Form.Control as="select" value={category} onChange={(e) => setCategory(e.target.value)} required>
                            <option value="">Select Category</option>
                            <option value="Fresh Fruits">Fresh Fruits</option>
                            <option value="Frozen">Frozen</option>
                            <option value="Chinese Memes">Chinese Memes</option>
                            <option value="Fresh Vegetables">Fresh Vegetables</option>
                        </Form.Control>
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Product Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter Product Name" value={productName} onChange={(e) => setProductName(e.target.value)} required/>
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Quantity</Form.Label>
                        <Form.Control type="text" placeholder="Enter Quantity" value={quantity} onChange={(e) => setQuantity(e.target.value)} />
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

                    {/*IDs*/}
                    {/* <Form.Group className="mb-3">
                        <Form.Label>Product ID</Form.Label>
                        <Form.Control type="text" placeholder="Enter Product ID" value={productID} onChange={(e) => setProductID(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Inventory ID</Form.Label>
                        <Form.Control type="text" placeholder="Enter Inventory ID" value={inventoryID} onChange={(e) => setInventoryID(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Store ID</Form.Label>
                        <Form.Control type="text" placeholder="Enter Store ID" value={storeID} onChange={(e) => setStoreID(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Category ID</Form.Label>
                        <Form.Control type="text" placeholder="Enter Category ID" value={categoryID} onChange={(e) => setCategoryID(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Supplier ID</Form.Label>
                        <Form.Control type="text" placeholder="Enter Supplier ID" value={supplierID} onChange={(e) => setSupplierID(e.target.value)} />
                    </Form.Group> */}

                    <Form.Group className="mb-3">
                        <Form.Label>Discount</Form.Label>
                        <Form.Control type="text" placeholder="$0.00" value={discount} onChange={(e) => setDiscount(e.target.value)} />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Last Ordered Date</Form.Label>
                        <Form.Control type="text" placeholder="XY-XY-XYXY" value={lastOrderedDate} onChange={(e) => setLastOrderedDate(e.target.value)} />
                    </Form.Group>

                    <Form.Label>Upload New Images</Form.Label>
                    <Form.Control 
                        disabled={isSubmitting}
                        type="file" 
                        onChange={e => handleImageChange(e.target.files[0])}
                    />
                    <br></br>
                </Form>

                {/* Error message for validation */}
                {validationError && <p className="text-danger">{validationError}</p>}

                <Button variant="secondary" onClick={handleClose}>Cancel</Button> &nbsp;&nbsp;&nbsp;
                <Button disabled={isSubmitting} variant="primary" onClick={handleSubmit} >                    {
                      // When submitting, display the spinner animation and change title from 
                      // "Submit Edits" to "Submitting"
                      isSubmitting 
                        ? 
                          <>
                            <Spinner
                              animation="grow"
                              size="sm"
                            />
                            Saving...
                          </> 
                        : 
                          <>Save Inventory</>
                    }
                </Button>
            </Modal.Body>
        </Modal>

    );
}

export default NewInventoryModal;