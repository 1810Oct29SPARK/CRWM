import {Player} from './player.model';

export class Leaderboard{
    id: number;
    player: Player;

    constructor(id: number, player: Player){
        this.id = id;
        this.player = player;
    }
}