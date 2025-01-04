import { render } from "@testing-library/react";
import ViewLandlord from "./../ViewLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("View Landlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><ViewLandlord/></Router>,div);
    })
    it ("Rendered View Button",()=>{
        const {getByTestId}=render(<Router><ViewLandlord/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})