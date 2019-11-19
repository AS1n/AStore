import {User} from "./user";

export class Wallet {
  id: string;
  user: User;
  name: string;
  description: string;
  value: number;

  static cloneBase(wallet: Wallet): Wallet {
    let clonedWallet: Wallet = new Wallet();
    clonedWallet.id = wallet.id;
    clonedWallet.name = wallet.name;
    clonedWallet.user = User.cloneBase(wallet.user);
    clonedWallet.description = wallet.description;
    clonedWallet.value = wallet.value;
    return clonedWallet;
  }
}
