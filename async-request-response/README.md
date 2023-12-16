# 개선포인트

- **polling 주기**
  - 문제
    - 현재 polling 주기를 acceptor 에서 내려주지 않는다. 고정된 값 사용
  - 해결 방안
    - operation 마다 polling 을 적절히 계산해준다
    - maxPollingCount 와 같은 프로퍼티를 제공하여 무한정 대기하지 않도록 한다
- **사용성**
  - 문제
    - 지금 코드는 직접 asyncOperation 관련 코드들을 비즈니스 로직에서 호출해야함
  - 해결 방안
    - AOP 를 적용하여 annotation 기반으로 만든다
- **asyncOperation 의 key**
  - 문제
    - 비동기로 asyncOperation 을 조작하는 행위가 비동기 이므로 다른 메서드에서 상태를 조작하기 위해서는 key 를 통해 조회해야한다
    - 그래서 event payload 에 key 가 항상 붙어있어야 한다
  - 해결방안
    - asyncOperation 의 key 를 event payload 내의 조합을 통해 key 를 추측할 수 있게 하거나 복합키를 이용한다
      - 명시적이지 않아서 유지보수가 어렵다
      - 하지만 asyncOperation 의 키 중복 문제도 있을 수 있다
- **처리되지 않은 asyncOperation**
  - 문제
    - pending 상태인 operation 이 처리되지 않는다면 계속해서 pending 상태일 수 있다
  - 해결방안
    - 오랫동안 pending 상태인 operation 을 검사하여 제거해야한다
    - 처리 시작하고 processing 상태를 넣던

