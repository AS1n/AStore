import {Category} from './category';
import {Wallet} from './wallet';

export class Product {
  id: number;
  name: string;
  description: string;
  cost: number;
  category: Category;
  wallet: Wallet;

  constructor() {
    this.category = new Category();
  }

  static cloneBase(product: Product): Product {
    const clonedProduct: Product = new Product();
    clonedProduct.id = product.id;
    clonedProduct.name = product.name;
    clonedProduct.description = product.description;
    clonedProduct.cost = product.cost;
    clonedProduct.category = product.category;
    clonedProduct.wallet = product.wallet;
    return clonedProduct;
  }

}
