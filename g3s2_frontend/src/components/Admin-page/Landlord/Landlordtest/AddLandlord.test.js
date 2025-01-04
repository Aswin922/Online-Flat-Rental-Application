import { render } from "@testing-library/react";
import AddLandlord from "./../AddLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Add Landlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><AddLandlord/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><AddLandlord/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})