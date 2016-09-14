Copyright (c) 2016. WorldGo Technology Co., Ltd
>Create on Ricky.Yao


## 常见Rx操作符代码示例 ##
![](http://i.imgur.com/gMmh6RR.png)

## Demo框架 ##
> 采用委托代理，便于修改

	/**
     * 创建操作
     */
    private static Catalog getCreate() {
        List<Catalog.SubCatalog> catalogList = new ArrayList<>();
        Collections.addAll(catalogList,
                new Catalog.SubCatalog("Create", new Event(Create.class, "invoke", null)),
                new Catalog.SubCatalog("Defer", new Event(Defer.class, "invoke", null)),
                new Catalog.SubCatalog("Empty", new Event(Empty.class, "invoke", null)),
                new Catalog.SubCatalog("Never", new Event(Never.class, "invoke", null)),
                new Catalog.SubCatalog("Error", new Event(Throw.class, "invoke", null)),
                new Catalog.SubCatalog("Interval", new Event(Interval.class, "invoke", null)),
                new Catalog.SubCatalog("Just", new Event(Just.class, "invoke", null)),
                new Catalog.SubCatalog("Range", new Event(Range.class, "invoke", null)),
                new Catalog.SubCatalog("Repeat", new Event(Repeat.class, "invoke", null)),
                new Catalog.SubCatalog("Timer", new Event(Timer.class, "invoke", null)),
                new Catalog.SubCatalog("Start(Todo)", new Event(Start.class, "invoke", null))
        );
        return new Catalog("创建操作", catalogList);
    }



