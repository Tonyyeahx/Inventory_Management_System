/**
 * @file Created a side menubar / navbar for the merchant view users
 * @author Yucheng Zang <yzang7@wisc.edu>
 */
// External imports
import React from 'react'
import { Sidebar, Menu, MenuItem, SubMenu} from 'react-pro-sidebar';

// Internal imports
import teamLogo from "../assets/TeamLogo.png"

// CSS imports
import "../App.css"
import "./MerchantNavbar.css"

function MerchantNavbar() {
    return (
        <Sidebar>
            {/* Display project/team logo here in the top of the menu bar.
                Used a logo wrapper to make it align at the center */}
            <div className="logo-wrapper">
                <img src={teamLogo} className="logo" alt="React logo" />
            </div>

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