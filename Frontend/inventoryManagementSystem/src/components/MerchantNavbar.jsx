/**
 * @file Created a side menubar / navbar for the merchant view users
 * @author Yucheng Zang <yzang7@wisc.edu>
 */
// External imports
import React from 'react'
import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';

// Internal imports
import "../App.css"

function MerchantNavbar() {
    return (
        <Sidebar>
            <Menu>
                <SubMenu label="Charts">
                    <MenuItem> Pie charts </MenuItem>
                    <MenuItem> Line charts </MenuItem>
                </SubMenu>
                <MenuItem> Documentation </MenuItem>
                <MenuItem> Calendar </MenuItem>
            </Menu>
        </Sidebar>
    );
}

export default MerchantNavbar