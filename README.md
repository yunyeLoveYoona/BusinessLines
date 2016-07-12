# BusinessLines
Android业务线架构

一个新的App开发架构，基于观察者模式实现。


我们把一个App看成一个公司，它主要是为用户提供某些产品或某些服务。
而这个公司由四个主要元素组成：
  （1）业务员（Activity）负责与用户沟通，把产品或者服务直接提供给用户
  （2）资源(用户提交的数据，公用的view，服务器数据，网络请求工具等等甚至App中用到的一切) 我们通过资源来生产产品
  （3）产品（展示给用户的数据，提供给用户的服务），产品最终通过业务员提供给用户
  （4）业务线(包括用户数据的处理、服务器数据的获取等等) 业务线通过整合各种资源然后生产产品并交给业务员
  
  例如 App中的登录功能是一条业务线，LoginActivity是这条业务线的业务员，服务器返回的登录信息数据是产品，用户输入的数据以及网络请求工具
  是资源。
  
  但是在实际项目中我们遇到的情况更加复杂，有时候一条业务线不止一个业务员（登录功能不止登录页面需要，在实现自动登录时也需要），有时候一个
  业务员也不止负责一条业务线（一个Activity会有多个不同的业务），有时多个业务要用到一个资源（例如网络请求工具是大部分业务实现都需要的，还
  有用户信息也可能是多个Activity都要用到的），有时一个产品被提供给多个业务员（当这个产品发生改变时，我们就要通知所有的业务员，这有时会是
  一个麻烦）。
  那么我们要解决的问题是什么：
  (1)业务线分工的清晰，这样能提供生产效率（这样能提高代码的可读性）
 （2）资源的共享，不仅包括我们本身已经拥有的资源（view，网络请求工具以及系统数据之类），而且包括我们生产的产品（如果已经生产的数据可以
 在其他Activity上使用，我们当然没有必要重新生产数据），以及业务线本身（一条业务线已经实现的接口请求当然没必要在其他业务上重复添加）
 （3）产品变动后通知所有拥有该产品的业务员（有时需要通知所有拥有该数据的用户数据已经改变）
 
 如何解决问题：
  我们把公司分成若干条业务线，以业务线为中心，来进行业务员、资源以及产品的整合。一条业务线可以加入多个业务员，同时也可以放入各种资源，
  包括其他业务线本身，每个产品都会有所属的业务线。这样同一业务线中的业务员就可以共享其中的所有资源，业务线也可以把其他业务线当做资源
  进行管理，这样业务线句不需要做重复业务了。产品有所属的业务线，就能知道拥有产品的业务员，就可以在产品改变时通知到所有的业务员。
  
  业务线架构就是以上面的逻辑进行开发的，每一个Activity都作为一个业务员，可以把要提供的功能抽象为一条业务线，把服务器返回的数据作为产品，
  从而实现业务功能和数据的共享。
  
