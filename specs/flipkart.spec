Flipkart
========

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, use

	gauge spec/hello_swiggy.spec


Add to cart
-----------

tags: smoke

* login to flipkart website
 search for "watch"
 select "Motorola Moto 360 Smartwatch" and add to cart
 search for "sunglasses"
 select "Joe Black Aviator Sunglasses" and add to cart
* add products to cart 
     |ProductType|productName|
     |-----------|-----------|
     |watch      |Fossil     |
     |mobile     |Lenovo     |
* place the order

Gift
-------

tags: smoke

* login to flipkart website
* buy a gift

