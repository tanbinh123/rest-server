Manual insert bean<br>

**Bag.java**

```java
@Bean
InitializingBean sendDatabase() {
	return () -> {
		Technology technologyJava = new Technology("java", null);
		Technology technologyJs = new Technology("js", null);

		eventRepository.save(new HashSet<Event>() {
			{
				add(new Event("Avantica", new Date(), new Date(), false, Type.job, new HashSet<Technology>() {

					{
						add(technologyJava);
						add(technologyJs);
					}
				}, "last job"));
			}
		});

		List<Technology> techs = technologyRepository.findByName(Arrays.asList("java", "js")).get();
		System.out.println();
	};
}
```