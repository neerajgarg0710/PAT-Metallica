import React from 'react';
import AppBar from 'material-ui/AppBar';
import IconButton from 'material-ui/IconButton';
import IconMenu from 'material-ui/IconMenu';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Avatar from 'material-ui/Avatar';
import {Tabs, Tab} from 'material-ui/Tabs';
import MenuItem from 'material-ui/MenuItem';
import DropDownMenu from 'material-ui/DropDownMenu';
import DatePicker from 'material-ui/DatePicker';
import Checkbox from 'material-ui/Checkbox';
import {Toolbar, ToolbarGroup, ToolbarSeparator, ToolbarTitle} from 'material-ui/Toolbar';




const style = {margin: 25};
const labelStyle = {color: 'white'};

const styles = {
    headline: {
        fontSize: 24,
        paddingTop: 16,
        marginBottom: 12,
        fontWeight: 400,
    },

    searchBar: {
        display:'inline-block',
        width:'auto'
    },
};

const Logged = (props) => (
    <div>
    <span style={labelStyle}>UserName</span>
    <Avatar size={30} style={style}>
    A
    </Avatar>
    </div>
);

Logged.muiName = 'IconMenu';
class App extends React.Component {
    render() {
        return (
            <MuiThemeProvider>
            
            <div>
                <div>
                    <AppBar title="Metallica App" iconElementRight={<Logged />}/>
                </div>

                <div>
                    <Tabs>
                        <Tab label="Trades" >
                            <div class="row">
                                <div class="col-sm-5">
                                    
                                    <label>Trade Date</label>
                                    
                                </div>
            
                                <div class="col-sm-1">
                                    <label>Commodity</label>

                                </div>
            
                                <div class="col-sm-2">
                                    <label>Side</label>
                                </div>
            
                                <div class="col-sm-2">
                                   <label>Counterparty</label>
                                </div>
                                
                                <div class="col-sm-2">
                                    <label>Location</label>
                                </div>
                            </div>
            
                            <div class="row">
                                <div class="col-sm-5">
                                    <DatePicker hintText="From Date Input" onChange={this.handleChange} style={styles.searchBar}/>
                                    <label>To</label>
                                    <DatePicker hintText="To Date Input" onChange={this.handleChange} style={styles.searchBar}/>
                                </div>
            
                                <div class="col-sm-1">
                                    <DropDownMenu value={1} onChange={this.handleChange} style={styles.searchBar}>
                                        <MenuItem value={1} primaryText="AL" />
                                    </DropDownMenu>
                                </div>
            
                                <div class="col-sm-2">
                                    <Checkbox name="StylesOverridingInlineExample" label="Buy" style={styles.searchBar}  inputStyle=            {styles.searchBar}/>
                                    <Checkbox name="StylesOverridingInlineExample" label="Sell" style={styles.searchBar}  inputStyle={styles.searchBar} />
                                </div>
            
                                <div class="col-sm-2">
                                    <DropDownMenu value={1} onChange={this.handleChange} style={styles.searchBar}>
                                        <MenuItem value={1} primaryText="Dolor" />
                                    </DropDownMenu>
                                </div>
                                
                                <div class="col-sm-2">
                                    <DropDownMenu value={1} onChange={this.handleChange} style={styles.searchBar}>
                                        <MenuItem value={1} primaryText="BA" />
                                    </DropDownMenu>
                                </div>
                            </div>
                        </Tab>

                        //Transfer Tab
                        <Tab label="Transfer" >
                            <div>
                                <h2 style={styles.headline}>This is out of scope for Full Stack development Excerise</h2>
                            </div>
                        </Tab>

                        //Transport Tab
                        < Tab label = "Transport" >
                            <div>
                                <h2 style={styles.headline}>This is out of scope for Full Stack development Excerise</h2>
                            </div>
                        </Tab>
                    </Tabs>
                </div>
            </div>
        </MuiThemeProvider>
        );
    }
}

export default App;