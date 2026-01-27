# STEP BACKEND

## CONTRIBUTION CONVENTION
- 기본 브랜치 구조
  - main (배포)
  - dev (테스트, 수정)
  - feature/기능명 (기능 추가)
  - fix/수정내용 (수정)

- 기능 추가 및 코드 수정 과정
  1. 기능 생성 시, feature/기능명 브랜치 생성
  2. 기능 작성 이후 main 브랜치로 PR
  3. PR 검토 이후 merge

## COMMIT CONVENTION
| Type     | Description |
|----------|-----|
| feat     | 새로운 기능 추가 |
| fix      | 버그 수정 |
| docs     | 문서 관련 |
| style    | 코드 스타일 변경 |
| refactor | 코드 리팩토링 |
| test     | 테스트 관련 코드 |
| build    | 빌드 관련 파일 수정 |
| ci       | CI 설정 파일 수정 |
| perf     | 성능 개선 |
| chore    | 그 외 자잘한 수정 |