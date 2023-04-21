# Idempotent Api 구현하기

- 문제 상황
- 해결
  - 1 db locking
    - row lock
      - pessimistic locking
    - cas
      - optimistic locking
  - 2 messaging
    - 요청과 처리 분리 (즉시성이 떨어짐)
  - 3 멱등키 이용

### References

- [https://asyncq.com/how-to-implement-idempotent-api-part-1](https://asyncq.com/how-to-implement-idempotent-api-part-1)
- [https://levelup.gitconnected.com/how-to-implement-idempotent-api-part-1-1bb4a92c8756](https://levelup.gitconnected.com/how-to-implement-idempotent-api-part-1-1bb4a92c8756)