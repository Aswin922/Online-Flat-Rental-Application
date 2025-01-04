import { render } from "@testing-library/react";
import RegisterLandlord from "./../RegisterLandlord";
import ReactDOM from 'react-dom';
import { BrowserRouter as Router} from "react-router-dom"

describe("RegisterLandlord Component",()=>{
    it("Renders without crashing",()=>{
        const div =document.createElement('div');
         ReactDOM.render(<Router><RegisterLandlord/></Router>,div);
    })
    it ("Rendered Add Button",()=>{
        const {getByTestId}=render(<Router><RegisterLandlord/></Router>);
        const button =getByTestId("button");
        expect(button).toBeTruthy();
    })
})