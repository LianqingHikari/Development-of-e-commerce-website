本电子商务网站为华南理工大学2021年计算机科学与工程学院《网络应用开发》课程的课程设计，根据课程设计要求，现将代码开源。

学号：201930640018

姓名：陈明奕

网站网址：http://8.134.109.53/lianqinghikari



下面对本项目中所用到的源代码的功能进行简单的说明：

##### src

###### dao

- CartDao 购物车相关的Dao
- LogDao 日志相关的Dao
- ProductDao 商品相关的Dao
- UserDao 用户相关的Dao

###### domain

- BrowseLog 浏览日志类
- BuyLog 购买日志类
- Cart 购物车类
- Product 商品类
- User 用户类

###### filter

- EncodingFilter 过滤器，主要用于解决乱码问题

###### service

- CartService 与购物车相关的服务，提供“获取所有订单”、“添加订单”、“删除订单”、“结算”功能。
- LogService 与日志相关的服务，提供“添加日志”、“搜索日志”的功能。
- ProductService 与商品相关的服务，提供“查找商品”、“添加商品”、“删除商品”、“更新商品”、“展示所有商品”的功能。
- UserService 与用户相关的服务，提供“注册”和“登录”的功能。

###### servlet

- AddBrowseLog 添加浏览日志
- AddCart 添加购物车信息
- AddProduct 添加商品
- DeleteCart 删除订单
- DeleteProduct 删除商品
- FindCart 搜索订单
- Login 登录
- Logout 登出
- MenuSearch 搜索商品
- PayCart 结算
- Register 登录
- Return 返回
- SearchAllProduct 搜索所有商品
- SendEmail 发送邮件
- ShowAllLog 展示所有日志
- ShowAllProduct 展示所有商品
- ShowSale 展示所有商品销量
- UpdateProduct 更新商品信息

###### utils

- DateSourceUtils 提供与数据库连接相关方法的工具类
- SendEmailUtils 提供发送邮件相关方法的工具类

##### web

###### client

- AddProduct 添加商品页面
- AdminCenter 管理员中心页面
- Cart 购物车页面
- DeleteCart 删除订单页面
- DeleteProduct 删除商品页面
- index 索引页面
- login 登录页面
- OperateSuccess 操作成功提示页面
- register 注册页面
- SearchResult 搜索结果页面
- ShowAllLog 展示所有日志页面
- ShowAllProduct 展示所有商品页面
- ShowSale 展示商品销售记录页面
- UpdateProduct 更新商品页面
- UserCenter 用户中心页面
