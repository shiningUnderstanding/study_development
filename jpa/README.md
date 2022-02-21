Java Persistence API

기존의 sql에 의존적이던 jdbc와 달리 객체지향적인 개발에 가까워지도록 도와주는 기술

Persistence Context(영속성)
LazyLoading(지연로딩)
등의 개념을 사용해 생산성과 효율성 모두를 잡을 수 있다.

연관관계
1. 다대일 단방향, 양방향
2. 일대다 단방향, 양방향
3. 일대일 단방향, 양방향
4. 다대다

즉시로딩
fetchType.EAGER
지연로딩
fetchType.LAZY

영속성전이
CASCADE
