import { render } from "@testing-library/react";
import UpdateLandlord from "./../UpdateLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Update Landlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><UpdateLandlord/></Router>,div);
    })
    it ("Rendered Update Button",()=>{
        const {getByTestId}=render(<Router><UpdateLandlord/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})