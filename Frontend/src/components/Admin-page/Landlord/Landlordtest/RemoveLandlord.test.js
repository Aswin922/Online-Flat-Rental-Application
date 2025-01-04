import { render } from "@testing-library/react";
import RemoveLandlord from "./../RemoveLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("Remove Landlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RemoveLandlord/></Router>,div);
    })
    it ("Rendered Remove Button",()=>{
        const {getByTestId}=render(<Router><RemoveLandlord/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})