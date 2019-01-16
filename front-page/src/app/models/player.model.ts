export class Player {
    id: number;
    username: string;
    password: string;
    score: number;
    firstName: string;
    lastName: string;
    isDev: string;

    constructor(id: number, username: string, password: string, score: number, firstName: string, lastName: string, isDev: string){
        this.id = id;
        this.username = username;
        this.password = password;
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDev = isDev;
    }
}