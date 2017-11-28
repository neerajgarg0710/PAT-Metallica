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
import Paper from 'material-ui/Paper';
    

import {
  Table,
  TableBody,
  TableHeader,
  TableHeaderColumn,
  TableRow,
  TableRowColumn,
} from 'material-ui/Table';

const style = {margin: 25};
const labelStyle = {color: 'white'};

const paperStyle = {
  height: 100,
  width: '98%',
  margin: 10,
  display: 'inline-block',
};

const paperForTable = {
  height: '100%',
  margin: 10,
  display: 'inline-block',
};

const paperForSidePanel = {
  height: '100%',
  margin: 10,
  display: 'inline-block',
};

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
    
    gridList: {
        width: '60%',
        overflowY: 'auto',
  }
};

const Logged = (props) => (
    <div>
    <span style={labelStyle}>UserName</span>
    <Avatar size={30} style={style}>
    A
    </Avatar>
    </div>
);

const tableData = [
  {
        "tradeId": 1101,
        "side": "BUY",
        "quanity": 50,
        "price": 100,
        "tradeDate": 61469260200000,
        "status": "OPEN",
        "commodity": {
            "code": "AL",
            "description": "Aluminum"
        },
        "counterParty": {
           "code": "Lorem",
            "description": "Lorem"
        },
        "location": {
            "code": "LN",
            "description": "London"
        }
    },
    {
        "tradeId": 1102,
        "side": "SELL",
        "quanity": 50,
        "price": 100,
        "tradeDate": 61469260200000,
        "status": "NOMINATED",
        "commodity": {
            "code": "AL",
            "description": "Aluminum"
        },
        "counterParty": {
            "code": "Lorem",
            "description": "Lorem"
        },
        "location": {
            "code": "LN",
            "description": "London"
        }
    },
    {
        "tradeId": 1103,
        "side": "SELL",
        "quanity": 30,
        "price": 125,
        "tradeDate": 61469346600000,
        "status": "OPEN",
        "commodity": {
            "code": "AL",
            "description": "Aluminum"
        },
        "counterParty": {
            "code": "Lorem",
            "description": "Lorem"
        },
        "location": {
            "code": "LN",
            "description": "London"
        }
    }

];

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
            
                        <Paper style={paperStyle} zDepth={1} >
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
                            </Paper>
      
            
            <div class="row">
            <div class="col-sm-9">
            
   <Paper style={paperForTable} zDepth={1} >         
<Table>
    <TableHeader displaySelectAll={false}>
      <TableRow>
        <TableHeaderColumn>Trade Date</TableHeaderColumn>
        <TableHeaderColumn>Commodity</TableHeaderColumn>
        <TableHeaderColumn>Side</TableHeaderColumn>
            
            <TableHeaderColumn>Qty(MT)</TableHeaderColumn>
        <TableHeaderColumn>Price(/MT)</TableHeaderColumn>
        <TableHeaderColumn>Counterparty</TableHeaderColumn>
        <TableHeaderColumn>Location</TableHeaderColumn>
            
      </TableRow>
    </TableHeader>
    <TableBody displayRowCheckbox={false}>
                                 
                                 
     {tableData.map((data) => (
             <TableRow key={data.tradeId}>>
        <TableRowColumn>{data.tradeDate}</TableRowColumn>
        <TableRowColumn>{data.commodity.code}</TableRowColumn>
        <TableRowColumn>{data.side}</TableRowColumn>
        <TableRowColumn>{data.quanity}</TableRowColumn>
        <TableRowColumn>{data.price}</TableRowColumn>
        <TableRowColumn>{data.counterParty.code}</TableRowColumn>
        <TableRowColumn>{data.location.code}</TableRowColumn>
                                 
      </TableRow>
            
      ))}
    
     
     
    </TableBody>
  </Table>
    </Paper>
    </div>
    <div class="col-sm-3">
    <Paper style={paperForSidePanel} zDepth={1} >
        
              <form>
                                       <div class="col-sm-1">
                                    <DropDownMenu value={1} onChange={this.handleChange} style={styles.searchBar}>
                                        <MenuItem value={1} primaryText="AL" />
                                    </DropDownMenu>
                                </div>
            </form>
          
        </Paper>
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