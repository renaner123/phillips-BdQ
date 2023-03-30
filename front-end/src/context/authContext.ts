import { createContext } from "react";

export type User = {
    "name" : string,
    "login" : string
    "id_client" : number,
    "role" : {
        "authority" : string
    } []

}

export type AuthType = {
    user? : User
    updateUser?(user?: User) : void
}

const initialValue: AuthType = {}

export const AuthContext = createContext(initialValue);
