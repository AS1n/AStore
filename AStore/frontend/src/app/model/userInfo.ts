export class UserInfo {
  id: string;
  name: string;
  dateOfBirth: Date;

  static cloneBase(userInfo: UserInfo): UserInfo {
    const clonedUserInfo: UserInfo = new UserInfo();
    clonedUserInfo.id = userInfo.id;
    clonedUserInfo.name = userInfo.name;
    clonedUserInfo.dateOfBirth = userInfo.dateOfBirth;
    return clonedUserInfo;
  }
}
