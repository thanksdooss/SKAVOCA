# [SKAVOCA] SKALA 교재 기반 핵심 IT 어휘 딕셔너리 (Master 270 Seeding Data)

> **총 수록 어휘**: **270개** 핵심 실무 IT 전문 어휘 (9개 교재 × 30선 전수 수록)  
> **출처**: SKALA 4기 정규 커리큘럼 9개 교재 교안 전수 분석 및 실무 매핑  
> **구성 필드**: 용어 원형, 풀네임, 한글 권장 발음, W3C 표준 SSML 태그, 비전공자 맞춤 쉬운 뜻풀이, 문맥 빈칸 예문(`{{term}}`), 지능형 오답 비교 피드백 딕셔너리

---

## 1. Git 이해 및 협업 활용 (30선)

### 📌 PR (Pull Request)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **PR** |
| **공식 풀네임** | Pull Request |
| **권장 발음** | 풀 리퀘스트 (피알) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pUl rI-kwEst">Pull Request</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 내가 작업한 브랜치의 코드를 원본 저장소(Main)에 합쳐달라고 팀원들에게 공식 검토를 요청하는 행위 |
| **문맥 빈칸 예문** | "기능 개발 브랜치 작업을 마친 후 동료들의 코드 리뷰를 거쳐 Main에 병합하기 위해 {{PR}}을 생성하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Push`<br>**비교 피드백:** Push는 로컬 코드를 원격 저장소로 단순히 올리는 행위이고, 병합 검토를 공식 요청하는 것은 PR입니다.<br>**오답 입력:** `Commit`<br>**비교 피드백:** Commit은 로컬에 변경 스냅샷을 기록하는 단위입니다. |

### 📌 Rollback (Rollback)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Rollback** |
| **공식 풀네임** | Rollback |
| **권장 발음** | 롤백 (Roll-back) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="roUl-b{k">Rollback</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 배포 후 심각한 시스템 장애 발생 시 즉각 직전의 안정적인 버전으로 되돌리는 긴급 조치 |
| **문맥 빈칸 예문** | "운영 서버 배포 직후 데이터베이스 접속 실패가 발생하여 즉시 이전 안정 버전으로 {{Rollback}}을 수행하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Revert`<br>**비교 피드백:** Revert는 특정 커밋의 변경점을 취소하는 새 커밋을 만드는 것이며, 운영 상태 전체를 직전으로 복구하는 조치는 Rollback입니다. |

### 📌 Rebase (Git Rebase)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Rebase** |
| **공식 풀네임** | Git Rebase |
| **권장 발음** | 리베이스 (Rebase) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ri-beIs">Rebase</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 브랜치의 베이스(시작점)를 최신 Main 커밋 뒤로 재배치하여 깔끔하고 선형적인 커밋 히스토리를 유지하는 Git 기법 |
| **문맥 빈칸 예문** | "커밋 이력을 복잡한 가지 모양 대신 일직선으로 정돈하여 병합하기 위해 `git merge` 대신 `git {{Rebase}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Merge`<br>**비교 피드백:** Merge는 두 브랜치를 병합하면서 Merge 커밋을 남기지만, Rebase는 커밋 히스토리를 일직선으로 재배치합니다. |

### 📌 Merge Conflict (Merge Conflict)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Merge Conflict** |
| **공식 풀네임** | Merge Conflict |
| **권장 발음** | 머지 컨플릭트 (병합 충돌) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="m3:dZ kAn-flIkt">Merge Conflict</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 두 개 이상의 브랜치에서 동일한 파일의 같은 라인을 서로 다르게 수정하여 Git이 자동으로 병합하지 못하는 상태 |
| **문맥 빈칸 예문** | "동료와 내가 동일한 파일의 25번째 줄을 서로 다르게 수정한 채 병합을 시도하여 {{Merge Conflict}}가 발생했다." |
| **혼동 오답 피드백** | **오답 입력:** `Deadlock`<br>**비교 피드백:** Deadlock은 DB나 쓰레드 자원 경쟁의 교착 상태이며, 소스코드 병합 충돌은 Merge Conflict입니다. |

### 📌 Staging Area (Staging Area (Index))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Staging Area** |
| **공식 풀네임** | Staging Area (Index) |
| **권장 발음** | 스테이징 에어리어 (인덱스) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="steI-dZIN E-ri-@">Staging Area</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 작업 디렉토리에서 수정한 파일 중 다음 커밋에 포함시킬 변경사항을 `git add` 명령어로 선별해 올리는 중간 준비 영역 |
| **문맥 빈칸 예문** | "수정된 파일 중 커밋에 포함할 변경사항만 골라 `git add` 명령으로 {{Staging Area}}에 등록하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Working Directory`<br>**비교 피드백:** Working Directory는 실제로 작업 중인 로컬 폴더이며, 커밋 대기 영역은 Staging Area(Index)입니다. |

### 📌 Cherry-pick (Git Cherry-pick)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Cherry-pick** |
| **공식 풀네임** | Git Cherry-pick |
| **권장 발음** | 체리픽 (Cherry-pick) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tSE-ri pIk">Cherry-pick</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 다른 브랜치에 있는 여러 커밋 중 내가 필요한 특정 단 하나의 커밋만 쏙 골라와서 현재 브랜치에 적용하는 Git 명령어 |
| **문맥 빈칸 예문** | "다른 개발자의 기능 브랜치 전체를 병합하지 않고 긴급 버그 핫픽스 커밋 하나만 가져오기 위해 `git {{Cherry-pick}}`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Clone`<br>**비교 피드백:** Clone은 원격 저장소 전체를 복제하는 명령어이며, 특정 단일 커밋만 골라 적용하는 것은 Cherry-pick입니다. |

### 📌 Stash (Git Stash)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Stash** |
| **공식 풀네임** | Git Stash |
| **권장 발음** | 스태시 (Stash) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="st{S">Stash</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 아직 완료되지 않은 작업 내용을 커밋하지 않고 임시 저장소에 잠시 안전하게 숨겨두는 명령어 |
| **문맥 빈칸 예문** | "작업 중 급한 핫픽스 요청이 들어와 현재 작업 내역을 임시 보관하기 위해 `git {{Stash}}`를 실행하고 브랜치를 전환했다." |
| **혼동 오답 피드백** | **오답 입력:** `Savepoint`<br>**비교 피드백:** Savepoint는 RDBMS 트랜잭션 내의 롤백 지점이며, Git 임시 작업 보관은 Stash입니다. |

### 📌 Commit (Git Commit)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Commit** |
| **공식 풀네임** | Git Commit |
| **권장 발음** | 커밋 (Commit) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="k@-mIt">Commit</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 스테이징 영역에 올라온 변경사항들을 메시지와 함께 로컬 저장소의 영구적인 스냅샷 버전으로 기록하는 기본 단위 |
| **문맥 빈칸 예문** | "로그인 기능 개발 단위를 의미 있는 설명과 함께 로컬 저장소에 영구 기록하기 위해 `git {{Commit}}`을 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Push`<br>**비교 피드백:** Push는 로컬 커밋들을 원격 서버로 전송하는 단계이며, 로컬에 스냅샷을 기록하는 것은 Commit입니다. |

### 📌 Branch (Git Branch)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Branch** |
| **공식 풀네임** | Git Branch |
| **권장 발음** | 브랜치 (Branch) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="br{ntS">Branch</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 원본 코드(Main)에 영향을 주지 않고 독립적으로 새로운 기능 개발이나 실험을 진행할 수 있는 가상 작업 분기선 |
| **문맥 빈칸 예문** | "메인 운영 코드에 영향을 주지 않고 결제 기능만을 독립적으로 개발하기 위해 별도의 feature {{Branch}}를 생성하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Tag`<br>**비교 피드백:** Tag는 특정 릴리즈 버전에 이름을 붙이는 고정 마크이며, 독립적인 개발 분기선은 Branch입니다. |

### 📌 HEAD (Git HEAD Pointer)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **HEAD** |
| **공식 풀네임** | Git HEAD Pointer |
| **권장 발음** | 헤드 (HEAD 포인터) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="hEd">HEAD</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 현재 작업 중인 로컬 브랜치의 가장 최신 커밋을 가리키는 Git의 특수 참조 포인터 |
| **문맥 빈칸 예문** | "현재 내가 체크아웃하여 바라보고 있는 브랜치의 가장 마지막 커밋 지점을 가리키는 포인터는 {{HEAD}}이다." |
| **혼동 오답 피드백** | **오답 입력:** `origin`<br>**비교 피드백:** origin은 기본 원격 저장소의 별칭이며, 현재 작업 커밋을 가리키는 포인터는 HEAD입니다. |

### 📌 Revert (Git Revert)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Revert** |
| **공식 풀네임** | Git Revert |
| **권장 발음** | 리버트 (Revert) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rI-v3:t">Revert</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 기존 커밋 이력을 삭제하지 않고, 과거 특정 커밋의 변경 내용을 정확히 정반대로 되돌리는 새로운 커밋을 생성하는 안전한 취소 방식 |
| **문맥 빈칸 예문** | "이미 원격에 Push된 커밋의 히스토리를 훼손하지 않고 안전하게 취소하기 위해 `git {{Revert}}`로 반대 커밋을 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Reset`<br>**비교 피드백:** Reset은 커밋 히스토리를 과거로 되돌려 삭제하므로 협업 브랜치에서는 위험하며, 새 반대 커밋을 만드는 Revert가 권장됩니다. |

### 📌 .gitignore (.gitignore File)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **.gitignore** |
| **공식 풀네임** | .gitignore File |
| **권장 발음** | 깃이그노어 (.gitignore) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="gIt Ig-nOr">.gitignore</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | API 비밀키, 빌드 산출물(node_modules, target), OS 임시파일 등 Git이 추적하지 않도록 제외할 파일 목록을 정의하는 설정 파일 |
| **문맥 빈칸 예문** | "DB 접속 비밀번호가 담긴 환경설정 파일과 빌드 폴더가 원격 저장소에 노출되지 않도록 {{.gitignore}} 파일에 등록했다." |
| **혼동 오답 피드백** | **오답 입력:** `README.md`<br>**비교 피드백:** README.md는 프로젝트 설명 문서이며, 버전 추적 제외 대상을 설정하는 파일은 .gitignore입니다. |

### 📌 Clone (Git Clone)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Clone** |
| **공식 풀네임** | Git Clone |
| **권장 발음** | 클론 (Clone) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kloUn">Clone</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 원격 저장소(GitHub)에 있는 프로젝트 전체 소스코드와 모든 커밋 히스토리를 내 로컬 컴퓨터로 통째로 복제해 오는 명령어 |
| **문맥 빈칸 예문** | "신규 프로젝트에 투입되어 팀의 원격 리포지토리를 내 컴퓨터로 처음 내려받기 위해 `git {{Clone}}`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Fork`<br>**비교 피드백:** Fork는 GitHub 상에서 내 계정 원격 저장소로 복사하는 것이며, 로컬 컴퓨터로 내려받는 것은 Clone입니다. |

### 📌 Fork (GitHub Fork)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Fork** |
| **공식 풀네임** | GitHub Fork |
| **권장 발음** | 포크 (Fork) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fOrk">Fork</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 다른 사람의 공개 원격 저장소를 내 개인 GitHub 계정 원격 저장소로 통째로 복사해 와서 독립적으로 수정할 수 있게 만드는 기능 |
| **문맥 빈칸 예문** | "오픈소스 라이브러리에 기여하기 위해 먼저 원본 저장소를 내 계정으로 {{Fork}}한 뒤 작업 브랜치를 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Clone`<br>**비교 피드백:** Clone은 로컬 PC로 다운로드하는 명령어이며, GitHub 상에서 내 계정 원격 리포지토리로 복사하는 것은 Fork입니다. |

### 📌 Fetch (Git Fetch)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Fetch** |
| **공식 풀네임** | Git Fetch |
| **권장 발음** | 페치 (Fetch) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fEtS">Fetch</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 원격 저장소의 최신 커밋 내역을 로컬로 가져오되, 현재 작업 브랜치와 자동으로 병합(Merge)하지 않고 변경사항만 확인하는 명령어 |
| **문맥 빈칸 예문** | "원격 저장소의 변경사항을 내 코드에 바로 합치지 않고 안전하게 비교 검토하기 위해 `git pull` 대신 `git {{Fetch}}`를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pull`<br>**비교 피드백:** Pull은 Fetch와 Merge를 한 번에 자동 수행하며, 병합 없이 변경 내역만 가져오는 것은 Fetch입니다. |

### 📌 Pull (Git Pull)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Pull** |
| **공식 풀네임** | Git Pull |
| **권장 발음** | 풀 (Pull) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pUl">Pull</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 원격 저장소의 최신 커밋들을 가져와서(Fetch) 현재 로컬 작업 브랜치에 즉시 병합(Merge)하는 일괄 명령어 |
| **문맥 빈칸 예문** | "팀원이 Main 브랜치에 새로 병합한 최신 코드를 내 로컬 브랜치에 동기화하기 위해 `git {{Pull}}`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Fetch`<br>**비교 피드백:** Fetch는 병합 없이 내역만 가져오는 명령어이며, 가져와서 즉시 병합까지 하는 것은 Pull입니다. |

### 📌 Push (Git Push)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Push** |
| **공식 풀네임** | Git Push |
| **권장 발음** | 푸시 (Push) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pUS">Push</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 로컬 저장소에서 완료된 커밋(Commit)들을 GitHub 같은 원격 저장소(Remote Repository)로 업로드하여 반영하는 명령어 |
| **문맥 빈칸 예문** | "로컬에서 작성한 기능 개발 커밋들을 팀원들과 공유하기 위해 원격 저장소로 `git {{Push}} origin feature/login`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Commit`<br>**비교 피드백:** Commit은 로컬 저장소에 스냅샷을 기록하는 것이며, 원격 서버로 전송하는 것은 Push입니다. |

### 📌 Fast-forward (Fast-forward Merge)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Fast-forward** |
| **공식 풀네임** | Fast-forward Merge |
| **권장 발음** | 패스트 포워드 (Fast-forward) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="f{st fOr-w@rd">Fast forward</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | Main 브랜치에 아무런 새로운 커밋이 없을 때, 기능 브랜치의 커밋으로 Main의 포인터만 단순히 앞으로 이동시키는 병합 방식 |
| **문맥 빈칸 예문** | "Main에 다른 변경사항이 없어 별도의 병합 커밋 생성 없이 포인터만 최신 커밋으로 이동하는 {{Fast-forward}} 병합이 이루어졌다." |
| **혼동 오답 피드백** | **오답 입력:** `3-way Merge`<br>**비교 피드백:** 3-way Merge는 양쪽 브랜치에 모두 새 커밋이 있을 때 병합 커밋을 만드는 방식이며, 포인터만 이동하는 것은 Fast-forward입니다. |

### 📌 Squash (Git Merge Squash)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Squash** |
| **공식 풀네임** | Git Merge Squash |
| **권장 발음** | 스쿼시 (Squash) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="skwAS">Squash</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 기능 브랜치에서 작업한 수많은 자잘한 커밋들을 깔끔하게 단 하나의 커밋으로 압축 묶음하여 Main에 병합하는 기법 |
| **문맥 빈칸 예문** | "지저분한 20개의 '오타 수정' 커밋들을 깔끔한 1개의 의미 있는 커밋으로 합쳐서 병합하기 위해 `git merge --{{Squash}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Rebase`<br>**비교 피드백:** Rebase는 커밋의 베이스를 변경하는 것이며, 여러 커밋을 1개로 합치는 것은 Squash입니다. |

### 📌 Git-flow (Git-flow Branch Strategy)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Git-flow** |
| **공식 풀네임** | Git-flow Branch Strategy |
| **권장 발음** | 깃-플로우 (브랜치 전략) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="gIt floU">Git flow</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | master, develop, feature, release, hotfix 5가지 브랜치를 엄격히 구분하여 대규모 소프트웨어를 안정적으로 릴리즈하는 표준 브랜치 전략 |
| **문맥 빈칸 예문** | "SKALA 엔지니어링 프로젝트의 체계적인 릴리즈 관리를 위해 master와 develop 브랜치를 주축으로 하는 {{Git-flow}} 전략을 채택했다." |
| **혼동 오답 피드백** | **오답 입력:** `Trunk-based`<br>**비교 피드백:** Trunk-based는 모든 개발자가 단일 메인 브랜치에 빈번히 커밋하는 경량 전략이며, 5개 브랜치로 체계화된 전략은 Git-flow입니다. |

### 📌 Hotfix (Git-flow Hotfix Branch)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Hotfix** |
| **공식 풀네임** | Git-flow Hotfix Branch |
| **권장 발음** | 핫픽스 (Hotfix) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="hAt-fIks">Hotfix</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 운영(Production) 서버에서 긴급한 치명적 버그가 터졌을 때, master 브랜치에서 즉시 따서 긴급 패치 후 배포하는 특수 브랜치 |
| **문맥 빈칸 예문** | "운영 환경에서 발생한 결제 오류 긴급 패치를 위해 develop 브랜치를 거치지 않고 master에서 바로 {{Hotfix}} 브랜치를 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Feature`<br>**비교 피드백:** Feature는 새로운 기능을 개발하기 위해 develop에서 따는 브랜치이며, 운영 긴급 수정용 브랜치는 Hotfix입니다. |

### 📌 Tag (Git Tag)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Tag** |
| **공식 풀네임** | Git Tag |
| **권장 발음** | 태그 (Tag) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="t{g">Tag</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 특정 커밋 지점을 `v1.0.0`처럼 소프트웨어 릴리즈 릴리스 버전을 명시하여 영구적으로 기억해 두는 북마크 포인터 |
| **문맥 빈칸 예문** | "첫 번째 정식 버전을 성공적으로 배포한 후 해당 커밋에 `git {{Tag}} -a v1.0.0 -m "Release 1.0"`을 달았다." |
| **혼동 오답 피드백** | **오답 입력:** `Branch`<br>**비교 피드백:** Branch는 커밋할 때마다 앞으로 계속 전진하는 작업선이지만, Tag는 특정 커밋에 고정된 릴리즈 라벨입니다. |

### 📌 Origin (Git Origin)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Origin** |
| **공식 풀네임** | Git Origin |
| **권장 발음** | 오리진 (기본 원격 저장소 별칭) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="O-rI-dZIn">Origin</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 저장소를 복제(Clone)했을 때 Git이 기본적으로 부여하는 중앙 원격 저장소 URL의 기본 별칭(Alias) |
| **문맥 빈칸 예문** | "로컬 커밋을 기본 원격 저장소의 main 브랜치로 전송하기 위해 `git push {{Origin}} main`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Upstream`<br>**비교 피드백:** Upstream은 Fork한 원본 원격 저장소를 주로 가리키며, 내가 Clone한 기본 원격 저장소는 Origin입니다. |

### 📌 Upstream (Git Upstream)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Upstream** |
| **공식 풀네임** | Git Upstream |
| **권장 발음** | 업스트림 (원본 상위 저장소) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Vp-strim">Upstream</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 내가 Fork해 온 원본 오픈소스 저장소처럼, 내 저장소보다 상위에 위치하는 오리지널 소스 저장소를 가리키는 원격 별칭 |
| **문맥 빈칸 예문** | "Fork해 온 내 리포지토리를 최신 오리지널 오픈소스 코드와 동기화하기 위해 {{Upstream}} 저장소로부터 fetch를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Origin`<br>**비교 피드백:** Origin은 내가 Fork한 내 원격 저장소이고, Fork의 모체가 되는 원본 저장소는 Upstream입니다. |

### 📌 Git Hooks (Git Hooks)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Git Hooks** |
| **공식 풀네임** | Git Hooks |
| **권장 발음** | 깃 훅 (Git Hooks) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="gIt hUks">Git Hooks</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 커밋(pre-commit)이나 푸시(pre-push) 등 Git의 특정 중요 이벤트 전후에 자동으로 실행되는 사용자 정의 쉘 스크립트 |
| **문맥 빈칸 예문** | "코드 스타일 린트(ESLint)를 통과하지 못한 코드가 커밋되는 것을 사전에 강제 차단하기 위해 `pre-commit` {{Git Hooks}}를 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `CI/CD`<br>**비교 피드백:** CI/CD는 원격 서버에서 실행되는 자동화 파이프라인이며, 개발자 로컬 Git 이벤트 시점에 즉각 동작하는 스크립트는 Git Hooks입니다. |

### 📌 WSL (Windows Subsystem for Linux)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **WSL** |
| **공식 풀네임** | Windows Subsystem for Linux |
| **권장 발음** | 더블유-에스-엘 (WSL) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dA-b@l-ju Es El">WSL</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Windows 운영체제 내부에서 가상머신(VM) 없이 리눅스(Ubuntu 등) 커널 환경을 네이티브 속도로 완벽히 구동할 수 있게 해주는 도구 |
| **문맥 빈칸 예문** | "Windows PC 환경에서 리눅스 기반의 Docker, Bash 스크립트, Python 개발 도구를 완벽히 실행하기 위해 {{WSL}} 2를 설치했다." |
| **혼동 오답 피드백** | **오답 입력:** `VirtualBox`<br>**비교 피드백:** VirtualBox는 무거운 하드웨어 가상화 도구이며, 윈도우 OS에 내장된 고성능 리눅스 서브시스템은 WSL입니다. |

### 📌 NVM (Node Version Manager)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **NVM** |
| **공식 풀네임** | Node Version Manager |
| **권장 발음** | 엔-브이-엠 (NVM) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="En vi Em">NVM</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 한 컴퓨터에서 여러 개의 Node.js 버전을 손쉽게 설치하고 프로젝트별로 자유롭게 전환(use)할 수 있게 관리해 주는 버전 관리 도구 |
| **문맥 빈칸 예문** | "구형 프로젝트는 Node 16으로, 최신 Vue 3 프로젝트는 Node 20으로 버전 충돌 없이 전환하기 위해 `{{NVM}} use 20`을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `NPM`<br>**비교 피드백:** NPM은 자바스크립트 패키지를 설치하는 패키지 매니저이고, Node.js 엔진 자체의 버전을 관리하는 도구는 NVM입니다. |

### 📌 Reset (Git Reset (--hard/--soft))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Reset** |
| **공식 풀네임** | Git Reset (--hard/--soft) |
| **권장 발음** | 리셋 (Git Reset) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ri-sEt">Reset</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 현재 작업 중인 브랜치의 HEAD 포인터를 이전의 특정 커밋으로 강제 되돌려 이후 커밋들을 작업 이력에서 취소하는 명령어 |
| **문맥 빈칸 예문** | "로컬에서 잘못 작성된 최근 2개의 커밋을 완전히 폐기하고 과거 상태로 돌아가기 위해 `git {{Reset}} --hard HEAD~2`를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Revert`<br>**비교 피드백:** Revert는 히스토리를 유지하며 반대 커밋을 생성하는 안전한 방식이고, 히스토리 자체를 과거로 되돌리는 명령어는 Reset입니다. |

### 📌 Status (Git Status)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Status** |
| **공식 풀네임** | Git Status |
| **권장 발음** | 스테이터스 (git status) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="st{-t@s">Status</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 현재 작업 디렉토리와 스테이징 영역에서 어떤 파일이 수정되었고, 어떤 파일이 커밋 대기 중인지 상태를 점검하는 기본 명령어 |
| **문맥 빈칸 예문** | "현재 브랜치에서 커밋되지 않은 변경 파일 목록과 추적되지 않는 새 파일을 확인하기 위해 `git {{Status}}`를 입력했다." |
| **혼동 오답 피드백** | **오답 입력:** `Log`<br>**비교 피드백:** Log는 이미 완료된 과거 커밋들의 히스토리를 확인하는 명령어이며, 현재 작업 중인 파일들의 상태를 보는 것은 Status입니다. |

### 📌 Log (Git Log)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 1. Git 이해 및 협업 활용 (30선) |
| **용어 원형** | **Log** |
| **공식 풀네임** | Git Log |
| **권장 발음** | 로그 (git log) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lOg">Log</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 저장소에 지금까지 기록된 커밋들의 해시 ID, 작성자, 작성 일시, 커밋 메시지 히스토리를 시간 순서대로 조회하는 명령어 |
| **문맥 빈칸 예문** | "이전에 동료가 작성한 커밋 메시지와 변경 이력을 확인하기 위해 `git {{Log}} --oneline --graph` 명령을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Status`<br>**비교 피드백:** Status는 현재 작업 디렉토리의 수정 상태를 확인하는 명령어이며, 과거 커밋들의 전체 역사를 조회하는 것은 Log입니다. |

---

## 2. 데이터 분석을 위한 Python 이해 (30선)

### 📌 List Comprehension (List Comprehension)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **List Comprehension** |
| **공식 풀네임** | List Comprehension |
| **권장 발음** | 리스트 컴프리헨션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lIst kAm-prI-hEn-S@n">List Comprehension</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | for문과 if문을 한 줄의 대괄호 [] 안에 함축하여 새로운 리스트를 빠르게 생성하는 파이썬 고유 문법 |
| **문맥 빈칸 예문** | "파이썬에서 여러 줄의 for문 대신 `[x**2 for x in data if x%2==0]` 형태로 리스트를 만드는 기법은 {{List Comprehension}}이다." |
| **혼동 오답 피드백** | **오답 입력:** `Lambda`<br>**비교 피드백:** Lambda는 익명 함수 정의 키워드이며, 리스트 생성 문법은 List Comprehension입니다. |

### 📌 Decorator (Python Decorator (@))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Decorator** |
| **공식 풀네임** | Python Decorator (@) |
| **권장 발음** | 데코레이터 (@) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dE-k@-reI-t@r">Decorator</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 기존 함수의 코드를 직접 수정하지 않고 실행 전후에 로깅, 인증, 시간측정 등의 부가 기능을 덧붙이는 `@` 문법 |
| **문맥 빈칸 예문** | "함수의 소스 수정 없이 실행 시간을 자동으로 측정하기 위해 함수 선언문 위에 `@timer` 형태의 {{Decorator}}를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Generator`<br>**비교 피드백:** Generator는 yield를 통해 이터레이터를 생성하는 함수이며, 부가 기능을 덧붙이는 문법은 Decorator입니다. |

### 📌 GIL (Global Interpreter Lock)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **GIL** |
| **공식 풀네임** | Global Interpreter Lock |
| **권장 발음** | 지-아이-엘 (글로벌 인터프리터 락) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZi-aI-El">GIL</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | CPython에서 메모리 안전성을 위해 여러 스레드가 존재해도 한 번에 오직 하나의 바이트코드만 실행하도록 잠그는 전역 락 |
| **문맥 빈칸 예문** | "파이썬의 CPython 인터프리터는 멀티스레딩 환경에서도 한 순간에 1개의 스레드만 CPU를 점유하도록 {{GIL}} 메커니즘을 사용한다." |
| **혼동 오답 피드백** | **오답 입력:** `JIT`<br>**비교 피드백:** JIT은 런타임 기계어 컴파일러 기술이며, 파이썬의 단일 스레드 실행 잠금장치는 GIL입니다. |

### 📌 Lambda (Lambda Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Lambda** |
| **공식 풀네임** | Lambda Function |
| **권장 발음** | 람다 (익명 함수) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="l{m-d@">Lambda</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `def` 키워드로 정식 함수를 만들지 않고 한 줄로 가볍게 작성하여 일회성으로 전달하는 익명 함수 |
| **문맥 빈칸 예문** | "데이터 정렬이나 map 함수에 인자로 넘길 간단한 연산을 위해 `def` 대신 `{{Lambda}} x: x * 2` 형태의 익명 함수를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Closure`<br>**비교 피드백:** Closure는 외부 스코프 변수를 기억하는 함수이며, 한 줄짜리 이름 없는 함수는 Lambda입니다. |

### 📌 Generator (Python Generator (yield))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Generator** |
| **공식 풀네임** | Python Generator (yield) |
| **권장 발음** | 제너레이터 (yield) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZE-n@-reI-t@r">Generator</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 모든 데이터를 메모리에 올리지 않고 `yield`를 통해 필요할 때마다 원소를 하나씩 지연 생성하는 특수 이터레이터 |
| **문맥 빈칸 예문** | "대용량 로그 파일을 메모리 부족(OOM) 없이 한 줄씩 지연 평가로 읽기 위해 `yield`를 사용하는 {{Generator}}를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Iterator`<br>**비교 피드백:** Iterator는 __next__()를 구현한 모든 반복 객체이며, yield로 간결하게 생성하는 함수는 Generator입니다. |

### 📌 DataFrame (Pandas DataFrame)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **DataFrame** |
| **공식 풀네임** | Pandas DataFrame |
| **권장 발음** | 데이터프레임 (Pandas) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="deI-t@-freIm">DataFrame</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 파이썬 Pandas 라이브러리에서 행(Row)과 열(Column)로 구성된 2차원 테이블 형태의 핵심 데이터 구조 |
| **문맥 빈칸 예문** | "CSV 파일에 저장된 고객 결제 내역을 행과 열 구조의 표로 가공하기 위해 Pandas의 {{DataFrame}} 객체로 로드하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Series`<br>**비교 피드백:** Series는 Pandas의 1차원 단일 열 데이터 구조이며, 2차원 표 형태의 구조는 DataFrame입니다. |

### 📌 Broadcasting (NumPy Broadcasting)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Broadcasting** |
| **공식 풀네임** | NumPy Broadcasting |
| **권장 발음** | 브로드캐스팅 (NumPy) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="brOd-k{s-tIN">Broadcasting</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | NumPy에서 모양(Shape)이 서로 다른 두 배열 간에 반복문 없이 자동으로 차원을 확장하여 빠른 벡터 산술 연산을 수행하는 기능 |
| **문맥 빈칸 예문** | "3x3 행렬의 모든 요소에 스칼라 값 10을 더할 때 for 루프 없이 한 번에 자동 연산되는 것은 NumPy의 {{Broadcasting}} 덕분이다." |
| **혼동 오답 피드백** | **오답 입력:** `Vectorization`<br>**비교 피드백:** 크기가 다른 배열의 차원을 자동 확장하여 연산 가능하게 만드는 메커니즘은 Broadcasting입니다. |

### 📌 Virtualenv (Python Virtual Environment (venv))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Virtualenv** |
| **공식 풀네임** | Python Virtual Environment (venv) |
| **권장 발음** | 가상환경 (버추얼엔브) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="v3:r-tSu-@l-En-vaI-r@n-m@nt">Virtualenv</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 프로젝트마다 서로 다른 패키지 버전 충돌을 방지하기 위해 독립된 파이썬 실행 환경과 라이브러리를 격리하는 도구 |
| **문맥 빈칸 예문** | "프로젝트 A는 Django 3.2를, 프로젝트 B는 Django 4.2를 사용할 수 있도록 서로 독립된 파이썬 {{Virtualenv}}를 구성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Docker`<br>**비교 피드백:** Docker는 OS 레벨의 컨테이너 격리 기술이며, 파이썬 패키지를 로컬에서 격리하는 환경은 Virtualenv입니다. |

### 📌 Type Hint (Python Type Hints (PEP 484))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Type Hint** |
| **공식 풀네임** | Python Type Hints (PEP 484) |
| **권장 발음** | 타입 힌트 (Type Hint) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="taIp hInt">Type Hint</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 동적 타입 언어인 파이썬에서 함수의 인자와 반환값에 명시적으로 기대하는 데이터 타입을 표기하여 코드 안정성을 높이는 문법 |
| **문맥 빈칸 예문** | "코드의 가독성과 IDE 자동완성 지원을 위해 `def calculate(price: int, rate: float) -> float:` 형태로 {{Type Hint}}를 추가했다." |
| **혼동 오답 피드백** | **오답 입력:** `Docstring`<br>**비교 피드백:** Docstring은 삼중 따옴표 설명 문서이며, 변수와 반환값의 타입을 명시하는 것은 Type Hint입니다. |

### 📌 *args/**kwargs (Variable Arguments (*args, **kwargs))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | ***args/**kwargs** |
| **공식 풀네임** | Variable Arguments (*args, **kwargs) |
| **권장 발음** | 가변 인자 (아그스 / 콰그스) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="A:rgz kwA:rgz">args kwargs</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 함수 호출 시 몇 개의 인자가 들어올지 알 수 없을 때 임의 개수의 위치 인자(튜플)와 키워드 인자(딕셔너리)를 동적으로 받는 문법 |
| **문맥 빈칸 예문** | "함수에 전달되는 인자의 개수가 가변적일 때 위치 인자는 `{{*args/**kwargs}}`의 *args로, 키워드 인자는 **kwargs로 받는다." |
| **혼동 오답 피드백** | **오답 입력:** `Destructuring`<br>**비교 피드백:** 가변 인자를 동적으로 수신하는 파이썬 문법은 *args/**kwargs입니다. |

### 📌 Series (Pandas Series)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Series** |
| **공식 풀네임** | Pandas Series |
| **권장 발음** | 시리즈 (Pandas 1차원) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sI-ri:z">Series</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Pandas에서 인덱스(Index) 레이블과 1차원의 데이터 배열을 결합해 놓은 단일 열 데이터 구조 |
| **문맥 빈칸 예문** | "DataFrame에서 '나이'라는 특정 단일 컬럼을 추출하면 인덱스와 값으로 이루어진 1차원 {{Series}} 객체가 반환된다." |
| **혼동 오답 피드백** | **오답 입력:** `List`<br>**비교 피드백:** List는 파이썬 기본 배열이며, 인덱스 레이블과 벡터 연산 기능을 갖춘 Pandas 1차원 데이터 구조는 Series입니다. |

### 📌 Docstring (Python Docstring)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Docstring** |
| **공식 풀네임** | Python Docstring |
| **권장 발음** | 독스트링 (Docstring) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dAk-strIN">Docstring</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 함수, 클래스, 모듈 바로 아래에 세 개의 따옴표 `"""`로 감싸서 작성하는 공식 설명 문서 문자열 (`help()`로 조회 가능) |
| **문맥 빈칸 예문** | "함수의 목적, 매개변수 설명, 예외 처리를 공식 문서화하기 위해 함수 첫 줄에 삼중 따옴표로 {{Docstring}}을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Comment`<br>**비교 피드백:** Comment는 단순 코드 주석(#)이며, 객체의 __doc__ 속성에 저장되어 런타임에 조회 가능한 공식 문서는 Docstring입니다. |

### 📌 DuckDB (DuckDB In-Process SQL OLAP)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **DuckDB** |
| **공식 풀네임** | DuckDB In-Process SQL OLAP |
| **권장 발음** | 덕디비 (DuckDB) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dVk-di-bi">DuckDB</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 별도의 DB 서버 설치 없이 파이썬 프로세스 내부에서 Parquet, Pandas 데이터를 초고속으로 SQL 분석하는 임베디드 분석 데이터베이스 |
| **문맥 빈칸 예문** | "Pandas 메모리 한계를 극복하고 수천만 건의 Parquet 파일을 빠른 벡터 쿼리로 분석하기 위해 파이썬 내장 `{{DuckDB}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `SQLite`<br>**비교 피드백:** SQLite는 행 기반 트랜잭션(OLTP)용 임베디드 DB이며, 컬럼 기반 고속 데이터 분석(OLAP)에 특화된 DB는 DuckDB입니다. |

### 📌 Polars (Polars DataFrame Library)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Polars** |
| **공식 풀네임** | Polars DataFrame Library |
| **권장 발음** | 폴라즈 (Polars) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="poU-l@rz">Polars</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | Rust로 작성되어 멀티코어 병렬 처리와 Apache Arrow 메모리 모델을 기반으로 Pandas보다 최대 수십 배 빠른 차세대 DataFrame 라이브러리 |
| **문맥 빈칸 예문** | "대용량 CSV 데이터를 단일 스레드인 Pandas 대신 멀티스레드 병렬 처리로 초고속 처리하기 위해 `{{Polars}}`를 도입했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pandas`<br>**비교 피드백:** Pandas는 단일 스레드 기반의 전통적 라이브러리이며, Rust 기반 멀티스레드 고속 처리를 지원하는 라이브러리는 Polars입니다. |

### 📌 Pydantic (Pydantic Data Validation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Pydantic** |
| **공식 풀네임** | Pydantic Data Validation |
| **권장 발음** | 파이댄틱 (Pydantic) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="paI-d{n-tIk">Pydantic</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 파이썬 타입 힌트를 기반으로 데이터의 유효성을 런타임에 자동 검증하고 객체로 파싱해 주는 핵심 데이터 모델링 라이브러리 |
| **문맥 빈칸 예문** | "FastAPI 서버에서 클라이언트가 보낸 JSON 요청 본문의 타입 일치 여부를 자동으로 검증하기 위해 `{{Pydantic}}` BaseModel을 정의했다." |
| **혼동 오답 피드백** | **오답 입력:** `Dataclass`<br>**비교 피드백:** Dataclass는 순수 데이터 보관용 표준 모듈이고, 런타임 유효성 검증과 타입 강제 변환 기능을 제공하는 라이브러리는 Pydantic입니다. |

### 📌 EDA (Exploratory Data Analysis)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **EDA** |
| **공식 풀네임** | Exploratory Data Analysis |
| **권장 발음** | 이-디-에이 (탐색적 데이터 분석) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="i-di-eI">EDA</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 본격적인 머신러닝 모델링에 앞서 데이터의 분포, 결측치, 이상치, 변수 간 상관관계를 통계량과 시각화로 파악하는 탐색 과정 |
| **문맥 빈칸 예문** | "데이터의 전반적인 구조를 이해하고 유용한 피처를 발굴하기 위해 본격적인 학습 전 단계로 `{{EDA}}`를 꼼꼼히 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `CDA`<br>**비교 피드백:** CDA(확증적 데이터 분석)는 가설을 통계적으로 검증하는 단계이며, 데이터의 패턴을 탐색하는 초기 과정은 EDA입니다. |

### 📌 Pytest (Pytest Framework)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Pytest** |
| **공식 풀네임** | Pytest Framework |
| **권장 발음** | 파이테스트 (Pytest) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="paI-tEst">Pytest</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 단순한 `assert` 문만으로도 강력하고 가독성 높은 단위 테스트 및 픽스처(Fixture) 기능을 제공하는 파이썬 표준 테스트 프레임워크 |
| **문맥 빈칸 예문** | "작성한 데이터 정제 함수의 동작 신뢰성을 검증하기 위해 간결한 문법의 `{{Pytest}}`로 단위 테스트 코드를 작성하고 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `unittest`<br>**비교 피드백:** unittest는 자바 JUnit 스타일의 클래스 기반 내장 모듈이며, assert 문으로 직관적인 테스트 작성을 지원하는 현대 표준은 Pytest입니다. |

### 📌 Dataclass (Python @dataclass)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Dataclass** |
| **공식 풀네임** | Python @dataclass |
| **권장 발음** | 데이터클래스 (@dataclass) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="deI-t@-kl{s">Dataclass</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `__init__`, `__repr__`, `__eq__` 같은 보일러플레이트 특수 메서드들을 데코레이터 선언 하나로 자동 생성해 주는 파이썬 3.7+ 표준 모듈 |
| **문맥 빈칸 예문** | "단순히 데이터를 담는 클래스에서 반복적인 생성자 코드를 줄이기 위해 클래스 선언 위에 `@{{Dataclass}}` 데코레이터를 붙였다." |
| **혼동 오답 피드백** | **오답 입력:** `Pydantic`<br>**비교 피드백:** Pydantic은 엄격한 런타임 데이터 유효성 검증 라이브러리이며, 표준 라이브러리 수준의 생성자 자동화는 Dataclass입니다. |

### 📌 Vectorization (Vectorized Operations)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Vectorization** |
| **공식 풀네임** | Vectorized Operations |
| **권장 발음** | 벡터화 연산 (Vectorization) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vEk-t@-rI-zeI-S@n">Vectorization</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 파이썬의 느린 for 루프 대신 C 언어로 최적화된 저수준 내부 루프를 통해 배열 전체에 일괄 연산을 적용하여 속도를 수백 배 높이는 기법 |
| **문맥 빈칸 예문** | "100만 건의 데이터에 10을 곱할 때 파이썬 for문 대신 NumPy의 `{{Vectorization}}` 연산을 적용하여 실행 시간을 1초에서 0.005초로 단축했다." |
| **혼동 오답 피드백** | **오답 입력:** `Broadcasting`<br>**비교 피드백:** Broadcasting은 서로 다른 크기의 배열을 맞추는 규칙이고, C 레벨에서 배열 전체를 일괄 고속 연산하는 것은 Vectorization입니다. |

### 📌 Context Manager (Context Manager (with statement))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Context Manager** |
| **공식 풀네임** | Context Manager (with statement) |
| **권장 발음** | 컨텍스트 매니저 (with문) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kAn-tEkst m{-nI-dZ@r">Context Manager</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | `with` 구문과 함께 사용되어 리소스의 획득(`__enter__`)과 해제(`__exit__`, close)를 예외 발생 여부와 무관하게 안전하게 보장하는 객체 |
| **문맥 빈칸 예문** | "파일을 연 후 예외가 발생하더라도 자동으로 `close()`되도록 `with open("data.txt") as f:` 형태의 {{Context Manager}}를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Decorator`<br>**비교 피드백:** Decorator는 함수에 기능을 덧붙이는 @ 문법이며, with문으로 자원을 안전하게 자동 해제하는 구조는 Context Manager입니다. |

### 📌 Magic Methods (Python Dunder Methods)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Magic Methods** |
| **공식 풀네임** | Python Dunder Methods |
| **권장 발음** | 매직 메서드 (던더 메서드) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="m{-dZIk mE-T@dz">Magic Methods</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | `__init__`, `__str__`, `__len__`, `__getitem__`처럼 앞뒤로 이중 밑줄(Dunder)이 붙어 파이썬의 내장 연산자나 함수와 상호작용하는 특수 메서드 |
| **문맥 빈칸 예문** | "내가 만든 커스텀 객체에 `len(obj)`를 호출했을 때 크기를 반환할 수 있도록 `__len__` {{Magic Methods}}를 구현했다." |
| **혼동 오답 피드백** | **오답 입력:** `Class Method`<br>**비교 피드백:** Class Method는 @classmethod가 붙은 클래스 단위 메서드이며, __로 감싸진 파이썬 특수 연산자 메서드는 Magic Methods(Dunder)입니다. |

### 📌 Dict Comprehension (Dict Comprehension)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Dict Comprehension** |
| **공식 풀네임** | Dict Comprehension |
| **권장 발음** | 딕트 컴프리헨션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dIkt kAm-prI-hEn-S@n">Dict Comprehension</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `{k: v for k, v in ...}` 문법을 사용하여 반복 가능한 데이터로부터 새로운 딕셔너리를 한 줄로 우아하게 생성하는 기법 |
| **문맥 빈칸 예문** | "학생 이름 리스트와 점수 리스트를 결합하여 `{name: score for name, score in zip(names, scores)}` 형태의 {{Dict Comprehension}}을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `List Comprehension`<br>**비교 피드백:** List Comprehension은 대괄호 []로 리스트를 만드는 문법이며, 중괄호 {}와 key: value 쌍으로 딕셔너리를 만드는 것은 Dict Comprehension입니다. |

### 📌 Set Comprehension (Set Comprehension)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Set Comprehension** |
| **공식 풀네임** | Set Comprehension |
| **권장 발음** | 셋 컴프리헨션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sEt kAm-prI-hEn-S@n">Set Comprehension</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `{x for x in ...}` 문법을 사용하여 중복 없는 집합(Set)을 한 줄로 간결하게 생성하는 파이썬 문법 |
| **문맥 빈칸 예문** | "텍스트 단어 리스트에서 중복을 자동으로 제거한 유니크 단어 집합을 만들기 위해 `{{Set Comprehension}}`을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Dict Comprehension`<br>**비교 피드백:** Dict Comprehension은 key: value 쌍을 갖지만, 단일 원소의 중복 없는 집합을 만드는 것은 Set Comprehension입니다. |

### 📌 loc / iloc (Pandas loc and iloc Indexing)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **loc / iloc** |
| **공식 풀네임** | Pandas loc and iloc Indexing |
| **권장 발음** | 엘오씨 / 아이엘오씨 (인덱서) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lAk aI-lAk">loc iloc</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Pandas에서 행과 열을 선택할 때 문자열 라벨 기반으로 접근하는 `loc`과 0부터 시작하는 정수 위치 인덱스 기반으로 접근하는 `iloc` |
| **문맥 빈칸 예문** | "명시적인 컬럼 이름으로 데이터를 슬라이싱할 때는 loc을 사용하고, 0번째 행부터 5번째 행까지 정수 번호로 가져올 때는 `{{loc / iloc}}`의 iloc을 사용한다." |
| **혼동 오답 피드백** | **오답 입력:** `Index`<br>**비교 피드백:** Index는 축의 라벨 자체이며, 라벨과 정수 위치로 데이터를 추출하는 Pandas 핵심 인덱서는 loc / iloc입니다. |

### 📌 GroupBy (Pandas GroupBy (Split-Apply-Combine))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **GroupBy** |
| **공식 풀네임** | Pandas GroupBy (Split-Apply-Combine) |
| **권장 발음** | 그룹바이 (Pandas 집계) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="grup baI">GroupBy</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터를 특정 기준 열에 따라 분할(Split)하고, 각 그룹별로 평균/합계 등의 함수를 적용(Apply)한 뒤 결과를 하나로 결합(Combine)하는 연산 |
| **문맥 빈칸 예문** | "지역별 고객들의 평균 구매 금액을 계산하기 위해 `df.{{GroupBy}}('region')['amount'].mean()` 코드를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pivot Table`<br>**비교 피드백:** Pivot Table은 2차원 교차 요약 행렬을 만드는 연산이며, 분할-적용-결합 메커니즘을 수행하는 기본 메서드는 GroupBy입니다. |

### 📌 Pivot Table (Pandas Pivot Table)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Pivot Table** |
| **공식 풀네임** | Pandas Pivot Table |
| **권장 발음** | 피벗 테이블 (Pandas) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pI-v@t teI-b@l">Pivot Table</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 엑셀의 피벗테이블처럼 특정 열들을 행 인덱스와 열 인덱스로 재배치하고 교차점에 집계 수치를 채워 넣는 2차원 요약 데이터프레임 |
| **문맥 빈칸 예문** | "연도별(행) 및 상품 카테고리별(열) 총 매출액을 한눈에 비교 요약하기 위해 `df.pivot_table()`을 사용하여 `{{Pivot Table}}`을 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `GroupBy`<br>**비교 피드백:** GroupBy는 1차원 계층 집계에 주로 쓰이고, 행과 열의 2차원 교차 분석표를 만드는 것은 Pivot Table입니다. |

### 📌 Pip (Python Package Installer (pip))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Pip** |
| **공식 풀네임** | Python Package Installer (pip) |
| **권장 발음** | 핍 (파이썬 패키지 관리자) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pIp">Pip</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 파이썬 공식 저장소(PyPI)로부터 수많은 오픈소스 외부 패키지(라이브러리)를 다운로드하고 설치 및 관리해 주는 기본 CLI 도구 |
| **문맥 빈칸 예문** | "데이터 분석에 필요한 Pandas와 NumPy 라이브러리를 설치하기 위해 터미널에서 `{{Pip}} install pandas numpy`를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `NPM`<br>**비교 피드백:** NPM은 Node.js의 자바스크립트 패키지 관리자이며, 파이썬 공식 패키지 매니저는 Pip입니다. |

### 📌 Axis (NumPy and Pandas Axis Parameter)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Axis** |
| **공식 풀네임** | NumPy and Pandas Axis Parameter |
| **권장 발음** | 액시스 (차원 축 파라미터) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="{k-sIs">Axis</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 다차원 배열이나 데이터프레임에서 연산 방향을 지정하는 인자로, `axis=0`은 행 방향(열 기준 아래로), `axis=1`은 열 방향(행 기준 가로로) 연산 |
| **문맥 빈칸 예문** | "데이터프레임의 불필요한 '나이' 컬럼을 가로 방향으로 날려 삭제하기 위해 `df.drop('age', {{Axis}}=1)`을 지정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Shape`<br>**비교 피드백:** Shape는 행과 열의 크기를 나타내는 튜플이며, 연산이 수행되는 방향 축을 지정하는 인자는 Axis입니다. |

### 📌 Zip (Python zip() Built-in Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Zip** |
| **공식 풀네임** | Python zip() Built-in Function |
| **권장 발음** | 집 (zip 내장 함수) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="zIp">Zip</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 길이가 같은 여러 개의 반복 가능한(Iterable) 객체들을 동일한 인덱스끼리 짝지어 튜플의 형태로 묶어주는 파이썬 내장 함수 |
| **문맥 빈칸 예문** | "이름 리스트 `['철수', '영희']`와 점수 리스트 `[90, 85]`를 묶어 동시에 순회하기 위해 `for name, score in {{Zip}}(names, scores):`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Enumerate`<br>**비교 피드백:** Enumerate는 (인덱스, 원소)를 반환하는 함수이고, 여러 리스트의 요소를 1:1로 짝지어 묶는 함수는 Zip입니다. |

### 📌 Enumerate (Python enumerate() Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 2. 데이터 분석을 위한 Python 이해 (30선) |
| **용어 원형** | **Enumerate** |
| **공식 풀네임** | Python enumerate() Function |
| **권장 발음** | 이뉴머레이트 (인덱스 순회) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-nju-m@-reIt">Enumerate</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 리스트 등의 반복 가능한 객체를 순회할 때 별도의 카운터 변수 없이 `(인덱스 번호, 원소 값)` 튜플을 동시에 반환해 주는 내장 함수 |
| **문맥 빈칸 예문** | "for 루프를 돌면서 각 항목의 순번(0, 1, 2...)을 함께 출력하기 위해 `for i, item in {{Enumerate}}(items):` 구문을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Zip`<br>**비교 피드백:** Zip은 서로 다른 두 개 이상의 리스트를 병렬로 묶어주는 함수이며, 인덱스 번호를 함께 꺼내주는 함수는 Enumerate입니다. |

---

## 3. 스마트 데이터 및 SQL / ETL (30선)

### 📌 PK (Primary Key)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **PK** |
| **공식 풀네임** | Primary Key |
| **권장 발음** | 기본키 (피케이) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="praI-mE-ri ki:">Primary Key</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 관계형 데이터베이스(RDBMS) 테이블에서 각 행(레코드)을 중복 없이 고유하게 식별할 수 있는 유일한 식별자 (NULL 불가) |
| **문맥 빈칸 예문** | "회원 테이블에서 중복 등록을 방지하고 각 회원을 고유하게 식별하기 위해 `user_id` 컬럼을 {{PK}}로 지정하였다." |
| **혼동 오답 피드백** | **오답 입력:** `FK`<br>**비교 피드백:** FK는 다른 테이블의 기본키를 참조하는 외래키이며, 테이블 내 고유 식별자는 PK입니다. |

### 📌 FK (Foreign Key)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **FK** |
| **공식 풀네임** | Foreign Key |
| **권장 발음** | 외래키 (에프케이) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fO-rIn ki:">Foreign Key</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 다른 테이블의 Primary Key를 참조하여 두 테이블 간의 관계(부모-자식)를 맺고 참조 무결성을 보장하는 컬럼 |
| **문맥 빈칸 예문** | "주문 테이블이 유효한 회원 데이터만을 참조할 수 있도록 `user_id` 컬럼을 회원 테이블의 PK를 바라보는 {{FK}}로 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `PK`<br>**비교 피드백:** PK는 해당 테이블의 고유 레코드 식별자이며, 다른 테이블의 기본키를 참조하는 컬럼은 FK입니다. |

### 📌 1NF (First Normal Form)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **1NF** |
| **공식 풀네임** | First Normal Form |
| **권장 발음** | 제1정규형 (1NF) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="f3:rst nOr-m@l fOrm">First Normal Form</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 관계형 데이터베이스 설계에서 테이블의 모든 컬럼 값이 더 이상 쪼갤 수 없는 '원자값(Atomic Value)'만을 가지도록 분리하는 규칙 |
| **문맥 빈칸 예문** | "하나의 '취미' 컬럼에 `[독서, 등산]`처럼 여러 값이 묶여 들어가지 않도록 분리하여 {{1NF}}을 만족시켰다." |
| **혼동 오답 피드백** | **오답 입력:** `2NF`<br>**비교 피드백:** 2NF는 부분 함수 종속성을 제거하는 단계이며, 컬럼의 원자값을 보장하는 단계는 1NF입니다. |

### 📌 ACID (ACID Properties of Transaction)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **ACID** |
| **공식 풀네임** | ACID Properties of Transaction |
| **권장 발음** | 에이시드 (트랜잭션 4대 특성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="{-sId">ACID</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 데이터베이스 트랜잭션의 신뢰성을 보장하는 4대 원칙: 원자성(Atomicity), 일관성(Consistency), 격리성(Isolation), 지속성(Durability) |
| **문맥 빈칸 예문** | "계좌 이체 시 출금과 입금이 모두 성공하거나 모두 취소되도록 트랜잭션의 {{ACID}} 특성을 엄격히 보장해야 한다." |
| **혼동 오답 피드백** | **오답 입력:** `BASE`<br>**비교 피드백:** BASE는 NoSQL의 가용성 모델이며, RDBMS의 신뢰성 4대 원칙은 ACID입니다. |

### 📌 INNER JOIN (SQL INNER JOIN)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **INNER JOIN** |
| **공식 풀네임** | SQL INNER JOIN |
| **권장 발음** | 이너 조인 (내부 조인) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-n@r dZOIn">INNER JOIN</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 두 개 이상의 테이블을 연결할 때 조인 조건에 일치하는 데이터가 양쪽 테이블에 모두 존재하는 행만 조회하는 SQL 연산 |
| **문맥 빈칸 예문** | "주문 내역과 회원 정보가 모두 완벽히 일치하는 구매 완료 건만 조회하기 위해 `{{INNER JOIN}}`을 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `LEFT JOIN`<br>**비교 피드백:** LEFT JOIN은 왼쪽 테이블을 모두 유지하는 방식이고, 양쪽 모두 일치하는 행만 조회하는 것은 INNER JOIN입니다. |

### 📌 LEFT JOIN (SQL LEFT OUTER JOIN)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **LEFT JOIN** |
| **공식 풀네임** | SQL LEFT OUTER JOIN |
| **권장 발음** | 레프트 조인 (왼쪽 외부 조인) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lEft dZOIn">LEFT JOIN</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 왼쪽 기준 테이블의 모든 행을 먼저 가져오고, 오른쪽 테이블에 매칭되는 데이터가 없으면 NULL로 채워 조회하는 SQL 연산 |
| **문맥 빈칸 예문** | "아직 한 번도 주문하지 않은 회원을 포함하여 전체 회원 목록과 주문 정보를 함께 보려면 `{{LEFT JOIN}}`을 사용해야 한다." |
| **혼동 오답 피드백** | **오답 입력:** `INNER JOIN`<br>**비교 피드백:** INNER JOIN은 주문 이력이 없는 회원은 제외하므로, 기준 테이블 전체 유지는 LEFT JOIN을 써야 합니다. |

### 📌 Index (Database Index (B-Tree))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Index** |
| **공식 풀네임** | Database Index (B-Tree) |
| **권장 발음** | 인덱스 (색인) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="In-dEks">Index</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 책의 색인처럼 특정 컬럼 값을 정렬된 트리 구조(B-Tree 등)로 별도 저장하여 `WHERE` 조건 검색 속도를 획기적으로 향상시키는 객체 |
| **문맥 빈칸 예문** | "1,000만 건의 회원 테이블에서 이메일 검색 속도를 0.01초로 단축하기 위해 `email` 컬럼에 {{Index}}를 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `View`<br>**비교 피드백:** View는 복잡한 쿼리를 가상 테이블로 정의한 객체이며, 검색 속도 향상용 별도 색인은 Index입니다. |

### 📌 GROUP BY (SQL GROUP BY Clause)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **GROUP BY** |
| **공식 풀네임** | SQL GROUP BY Clause |
| **권장 발음** | 그룹 바이 (집계 그룹화) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="grup baI">GROUP BY</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 동일한 값을 가진 행들을 하나의 그룹으로 묶어 `COUNT()`, `SUM()`, `AVG()` 등의 집계 함수를 적용할 때 사용하는 SQL 구문 |
| **문맥 빈칸 예문** | "각 부서별 총 급여 합계와 평균 인원을 계산하기 위해 부서 코드 컬럼을 기준으로 `{{GROUP BY}}` 절을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `ORDER BY`<br>**비교 피드백:** ORDER BY는 조회 결과를 정렬하는 절이며, 특정 컬럼 기준으로 집계 묶음을 만드는 구문은 GROUP BY입니다. |

### 📌 HAVING (SQL HAVING Clause)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **HAVING** |
| **공식 풀네임** | SQL HAVING Clause |
| **권장 발음** | 해빙 (그룹 집계 조건절) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="h{-vIN">HAVING</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | `GROUP BY`로 묶인 집계 결과에 대해 `SUM() > 1000`이나 `COUNT(*) >= 5`처럼 조건을 걸어 필터링할 때 사용하는 전용 조건절 |
| **문맥 빈칸 예문** | "총 주문 금액이 100만 원 이상인 우수 고객 그룹만을 필터링하기 위해 `GROUP BY` 뒤에 `{{HAVING}} SUM(price) >= 1000000`을 명시했다." |
| **혼동 오답 피드백** | **오답 입력:** `WHERE`<br>**비교 피드백:** WHERE는 집계 전 개별 행을 필터링하는 조건절이며, GROUP BY 집계 결과에 조건을 거는 절은 HAVING입니다. |

### 📌 Subquery (SQL Subquery)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Subquery** |
| **공식 풀네임** | SQL Subquery |
| **권장 발음** | 서브쿼리 (하위 질의) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sVb-kwI-ri">Subquery</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 하나의 SQL 문장 내부에 괄호 `()`로 감싸져 포함되어 메인 쿼리에 결과값을 제공하는 중첩된 내부 쿼리 |
| **문맥 빈칸 예문** | "전체 사원의 평균 연봉보다 더 많은 연봉을 받는 직원을 조회하기 위해 `WHERE salary > ({{Subquery}})` 형태로 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Stored Procedure`<br>**비교 피드백:** Stored Procedure는 DB에 저장된 일련의 함수이며, 쿼리문 안에 중첩된 쿼리는 Subquery입니다. |

### 📌 Deadlock (Database Deadlock)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Deadlock** |
| **공식 풀네임** | Database Deadlock |
| **권장 발음** | 데드락 (교착 상태) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dEd-lAk">Deadlock</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 두 개 이상의 트랜잭션이 서로 상대방이 잠근(Lock) 데이터의 잠금이 풀리기를 무한정 기다리며 시스템이 멈추는 교착 상태 |
| **문맥 빈칸 예문** | "트랜잭션 A는 1번을 잡고 2번을 기다리고, B는 2번을 잡고 1번을 기다려 {{Deadlock}}이 발생해 DB가 강제 롤백시켰다." |
| **혼동 오답 피드백** | **오답 입력:** `Race Condition`<br>**비교 피드백:** 상호 잠금 대기로 무한정 멈추는 현상은 Deadlock입니다. |

### 📌 ETL (Extract, Transform, Load)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **ETL** |
| **공식 풀네임** | Extract, Transform, Load |
| **권장 발음** | 이-티-엘 (데이터 추출, 변환, 적재) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="i-ti-El">ETL</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 다양한 원천 시스템에서 데이터를 추출(Extract)하고, 정제/가공(Transform)하여 분석용 저장소에 적재(Load)하는 파이프라인 |
| **문맥 빈칸 예문** | "로그 서버와 외부 API 데이터를 수집·가공하여 데이터 웨어하우스로 매일 자정 배치 적재하는 {{ETL}} 파이프라인을 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `CRUD`<br>**비교 피드백:** 대용량 데이터 추출·변환·적재 파이프라인 프로세스는 ETL입니다. |

### 📌 DDL (Data Definition Language)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **DDL** |
| **공식 풀네임** | Data Definition Language |
| **권장 발음** | 디-디-엘 (데이터 정의어) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-di-El">DDL</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터베이스의 구조나 객체를 생성(CREATE), 수정(ALTER), 삭제(DROP), 초기화(TRUNCATE)할 때 사용하는 SQL 명령어 군 |
| **문맥 빈칸 예문** | "신규 회원 정보를 담을 테이블 구조와 제약조건을 새로 정의하기 위해 `CREATE TABLE` {{DDL}} 문을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `DML`<br>**비교 피드백:** DML은 SELECT, INSERT 등 데이터를 다루는 조작어이며, 테이블 구조 자체를 생성/수정하는 것은 DDL입니다. |

### 📌 DML (Data Manipulation Language)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **DML** |
| **공식 풀네임** | Data Manipulation Language |
| **권장 발음** | 디-엠-엘 (데이터 조작어) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-Em-El">DML</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터베이스 테이블 내의 실제 행 데이터를 조회(SELECT), 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)하는 SQL 명령어 군 |
| **문맥 빈칸 예문** | "신규 가입한 사용자의 정보를 회원 테이블에 새로 추가하기 위해 `INSERT INTO` {{DML}} 쿼리를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `DDL`<br>**비교 피드백:** 테이블의 데이터를 조회하고 조작하는 명령어는 DML입니다. |

### 📌 DCL (Data Control Language)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **DCL** |
| **공식 풀네임** | Data Control Language |
| **권장 발음** | 디-씨-엘 (데이터 제어어) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-si-El">DCL</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 데이터베이스에 대한 접근 권한을 사용자에게 부여(GRANT)하거나 회수(REVOKE)하여 보안을 관리하는 SQL 명령어 군 |
| **문맥 빈칸 예문** | "신입 개발자 DB 계정에 특정 테이블의 읽기 권한만을 안전하게 부여하기 위해 `GRANT SELECT` {{DCL}} 문을 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `TCL`<br>**비교 피드백:** TCL은 트랜잭션을 제어하는 COMMIT/ROLLBACK이며, 사용자 권한을 부여/회수하는 것은 DCL입니다. |

### 📌 TCL (Transaction Control Language)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **TCL** |
| **공식 풀네임** | Transaction Control Language |
| **권장 발음** | 티-씨-엘 (트랜잭션 제어어) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ti-si-El">TCL</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 트랜잭션의 작업 결과를 영구 반영(COMMIT), 취소(ROLLBACK), 또는 중간 저장점(SAVEPOINT)을 설정하는 SQL 제어어 |
| **문맥 빈칸 예문** | "여러 계좌 간 송금 쿼리가 모두 오류 없이 정상 완료된 후 변경사항을 최종 확정하기 위해 `COMMIT` {{TCL}}을 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `DCL`<br>**비교 피드백:** 트랜잭션의 커밋과 롤백을 제어하는 명령어는 TCL입니다. |

### 📌 SARGable (Search Argument Able Query)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **SARGable** |
| **공식 풀네임** | Search Argument Able Query |
| **권장 발음** | 사저블 (SARGable 쿼리) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sA:r-g@-b@l">SARGable</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | WHERE 조건절에서 컬럼을 가공하지 않고 원형 그대로 비교하여 인덱스를 정상적으로 탈 수 있게 작성된 최적화 쿼리 형태 |
| **문맥 빈칸 예문** | "`WHERE SUBSTRING(name, 1, 3) = 'Kim'` 대신 `WHERE name LIKE 'Kim%'`로 작성하여 인덱스를 타는 {{SARGable}} 쿼리로 개선했다." |
| **혼동 오답 피드백** | **오답 입력:** `Full Table Scan`<br>**비교 피드백:** 인덱스를 정상적으로 활용할 수 있는 최적화된 쿼리 작성 형태를 SARGable이라고 합니다. |

### 📌 EXPLAIN (SQL EXPLAIN Query Plan)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **EXPLAIN** |
| **공식 풀네임** | SQL EXPLAIN Query Plan |
| **권장 발음** | 익스플레인 (실행 계획 분석) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Ik-spleIn">EXPLAIN</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 옵티마이저가 쿼리를 처리할 때 어떤 인덱스를 사용하고 몇 개의 행을 스캔하는지 실행 계획(Query Plan)을 상세히 출력하는 명령어 |
| **문맥 빈칸 예문** | "느린 조회 쿼리의 성능 병목을 진단하고 인덱스 사용 여부를 확인하기 위해 쿼리 앞에 `{{EXPLAIN}}` 키워드를 붙여 분석했다." |
| **혼동 오답 피드백** | **오답 입력:** `DESCRIBE`<br>**비교 피드백:** DESCRIBE는 테이블의 컬럼 스키마를 보는 것이며, 쿼리의 내부 실행 계획을 분석하는 명령어는 EXPLAIN입니다. |

### 📌 2NF (Second Normal Form)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **2NF** |
| **공식 풀네임** | Second Normal Form |
| **권장 발음** | 제2정규형 (2NF) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sE-k@nd nOr-m@l fOrm">Second Normal Form</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 제1정규형을 만족하고, 복합 기본키의 일부 컬럼에만 종속되는 '부분 함수 종속성'을 완전히 제거하여 완전 함수 종속을 만드는 정규화 |
| **문맥 빈칸 예문** | "복합키 (주문번호, 상품번호) 중 상품번호에만 종속되는 '상품명' 컬럼을 별도 테이블로 분리하여 {{2NF}}을 달성했다." |
| **혼동 오답 피드백** | **오답 입력:** `1NF`<br>**비교 피드백:** 부분 함수 종속성을 제거하는 단계는 2NF입니다. |

### 📌 3NF (Third Normal Form)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **3NF** |
| **공식 풀네임** | Third Normal Form |
| **권장 발음** | 제3정규형 (3NF) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="T3:rd nOr-m@l fOrm">Third Normal Form</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 제2정규형을 만족하고, 기본키가 아닌 일반 컬럼 간에 종속이 발생하는 '이행적 함수 종속성(A→B, B→C)'을 제거하는 정규화 |
| **문맥 빈칸 예문** | "사원ID(PK) → 부서코드 → 부서명으로 이어지는 이행적 종속을 끊기 위해 부서 정보를 분리하여 {{3NF}}을 완료했다." |
| **혼동 오답 피드백** | **오답 입력:** `2NF`<br>**비교 피드백:** 일반 컬럼 간의 이행적 종속성을 제거하는 정규화는 3NF입니다. |

### 📌 BCNF (Boyce-Codd Normal Form)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **BCNF** |
| **공식 풀네임** | Boyce-Codd Normal Form |
| **권장 발음** | 비씨엔에프 (강한 제3정규형) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bOIs kAd nOr-m@l fOrm">BCNF</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 제3정규형을 만족하면서, 테이블에 존재하는 모든 결정자(Determinant)가 반드시 후보키(Candidate Key)가 되도록 분리하는 정규화 |
| **문맥 빈칸 예문** | "후보키가 아닌 일반 결정자 컬럼이 다른 컬럼을 결정하는 이상 현상을 해결하기 위해 테이블을 {{BCNF}} 수준으로 분해했다." |
| **혼동 오답 피드백** | **오답 입력:** `3NF`<br>**비교 피드백:** 모든 결정자가 후보키가 되도록 엄격히 분리하는 정규형은 BCNF입니다. |

### 📌 De-normalization (Database De-normalization)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **De-normalization** |
| **공식 풀네임** | Database De-normalization |
| **권장 발음** | 역정규화 (반정규화) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-nOr-m@-lI-zeI-S@n">De-normalization</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 정규화로 쪼개진 테이블들로 인해 빈번한 JOIN 연산 부하가 발생할 때, 조회 성능 향상을 위해 의도적으로 중복 컬럼을 추가하는 기법 |
| **문맥 빈칸 예문** | "대규모 트래픽 환경에서 JOIN 비용을 줄이고 초고속 조회를 실현하기 위해 정규화된 스키마에 의도적인 `{{De-normalization}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Normalization`<br>**비교 피드백:** 성능 향상을 위해 의도적으로 데이터를 중복시키는 것은 역정규화(De-normalization)입니다. |

### 📌 Unique Constraint (UNIQUE Constraint)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Unique Constraint** |
| **공식 풀네임** | UNIQUE Constraint |
| **권장 발음** | 유니크 제약조건 (중복 불가) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ju-nik k@n-streInt">Unique Constraint</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 테이블의 특정 컬럼에 중복된 값이 들어올 수 없도록 강제하는 제약조건 (PK와 달리 NULL 허용 가능) |
| **문맥 빈칸 예문** | "사용자의 '휴대폰 번호'가 회원 테이블에서 서로 중복되지 않도록 컬럼에 `{{Unique Constraint}}`를 지정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Primary Key`<br>**비교 피드백:** PK는 NULL을 허용하지 않지만, UNIQUE 제약조건은 중복 방지와 함께 NULL을 허용할 수 있습니다. |

### 📌 Check Constraint (CHECK Constraint)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Check Constraint** |
| **공식 풀네임** | CHECK Constraint |
| **권장 발음** | 체크 제약조건 (값 유효성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tSEk k@n-streInt">Check Constraint</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 컬럼에 저장될 수 있는 데이터의 조건 범위(예: `age >= 0 AND age <= 150`)를 지정하여 잘못된 값 입력을 원천 차단하는 제약 |
| **문맥 빈칸 예문** | "'나이' 컬럼에 음수가 들어오거나 '성별' 컬럼에 유효하지 않은 문자가 들어오지 못하도록 `{{Check Constraint}}`를 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Default`<br>**비교 피드백:** Default는 기본값을 주는 것이고, 조건식을 통해 값의 범위를 검사하는 것은 Check Constraint입니다. |

### 📌 Default Constraint (DEFAULT Constraint)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Default Constraint** |
| **공식 풀네임** | DEFAULT Constraint |
| **권장 발음** | 디폴트 제약조건 (기본값) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dI-fOlt k@n-streInt">Default Constraint</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터를 INSERT할 때 해당 컬럼 값을 명시적으로 지정하지 않으면 자동으로 채워질 기본값을 정의하는 제약조건 |
| **문맥 빈칸 예문** | "신규 회원이 가입할 때 가입일시(`created_at`) 컬럼에 현재 시각이 자동으로 들어가도록 `{{Default Constraint}} now()`를 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Not Null`<br>**비교 피드백:** 값을 지정하지 않았을 때 자동으로 채워지는 기본값 규칙은 Default Constraint입니다. |

### 📌 Cascade (ON DELETE CASCADE)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Cascade** |
| **공식 풀네임** | ON DELETE CASCADE |
| **권장 발음** | 캐스케이드 (연쇄 삭제/수정) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="k{s-keId">Cascade</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 외래키(FK) 관계에서 부모 테이블의 행이 삭제되거나 수정될 때 이를 참조하는 자식 테이블의 행들도 연쇄적으로 함께 처리하는 옵션 |
| **문맥 빈칸 예문** | "회원이 탈퇴하여 user 행이 삭제될 때 해당 회원의 모든 주문 상세 내역도 자동으로 함께 삭제되도록 `ON DELETE {{Cascade}}`를 지정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Restrict`<br>**비교 피드백:** Restrict는 자식 데이터가 있으면 부모 삭제를 차단하는 옵션이며, 연쇄 삭제는 Cascade입니다. |

### 📌 UNION ALL (SQL UNION ALL)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **UNION ALL** |
| **공식 풀네임** | SQL UNION ALL |
| **권장 발음** | 유니온 올 (결과 집합 병합) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ju-nj@n Ol">UNION ALL</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 두 개 이상의 SELECT 쿼리 결과를 중복 제거(Distinct 정렬) 없이 있는 그대로 빠르게 위아래로 합쳐주는 집합 연산자 |
| **문맥 빈칸 예문** | "올해 상반기 매출 테이블과 하반기 매출 테이블을 중복 검사 오버헤드 없이 고속으로 합쳐 조회하기 위해 `{{UNION ALL}}`을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `UNION`<br>**비교 피드백:** UNION은 중복을 제거하기 위해 정렬 연산을 거쳐 느리지만, 중복 제거 없이 고속 병합하는 연산자는 UNION ALL입니다. |

### 📌 Window Function (SQL Window Function (OVER clause))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Window Function** |
| **공식 풀네임** | SQL Window Function (OVER clause) |
| **권장 발음** | 윈도우 함수 (OVER 절) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wIn-doU fVNk-S@n">Window Function</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 행들의 그룹에 대해 집계나 순위를 계산하면서도 `GROUP BY`와 달리 원본 행의 개수를 유지한 채 결과를 붙여주는 고급 SQL 함수 |
| **문맥 빈칸 예문** | "부서별로 사원들의 급여 순위를 1등부터 차례대로 매기기 위해 `ROW_NUMBER() OVER(PARTITION BY dept ORDER BY salary DESC)` {{Window Function}}을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Aggregate Function`<br>**비교 피드백:** GROUP BY 집계는 행을 줄여버리지만, 원본 행을 유지하며 순위/누적합을 계산하는 함수는 Window Function입니다. |

### 📌 Data Warehouse (Data Warehouse (DW))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Data Warehouse** |
| **공식 풀네임** | Data Warehouse (DW) |
| **권장 발음** | 데이터 웨어하우스 (대규모 분석 저장소) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="deI-t@ wE-r-haUs">Data Warehouse</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 기업의 다양한 운영 시스템에서 추출된 데이터를 통합, 정제하여 의사결정 및 대규모 비즈니스 분석(OLAP)을 위해 축적하는 중앙 저장소 |
| **문맥 빈칸 예문** | "실시간 서비스 DB의 부하를 주지 않고 전사 경영 통계와 머신러닝 분석을 수행하기 위해 전용 `{{Data Warehouse}}`를 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `Data Mart`<br>**비교 피드백:** Data Mart는 특정 부서나 특정 주제에 맞춘 소규모 분석 DB이며, 전사 차원의 대규모 통합 저장소는 Data Warehouse입니다. |

### 📌 Transaction Isolation Level (Transaction Isolation Levels)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 3. 스마트 데이터 및 SQL / ETL (30선) |
| **용어 원형** | **Transaction Isolation Level** |
| **공식 풀네임** | Transaction Isolation Levels |
| **권장 발음** | 트랜잭션 격리 수준 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tr{n-z{k-S@n aI-s@-leI-S@n lE-v@l">Isolation Level</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 동시에 실행되는 여러 트랜잭션 간에 변경 중인 데이터를 어디까지 서로 볼 수 있게 허용할지 격리 정도를 정의한 설정 |
| **문맥 빈칸 예문** | "더티 리드(Dirty Read)를 방지하고 트랜잭션의 안전성을 확보하기 위해 DB의 `{{Transaction Isolation Level}}`을 READ COMMITTED로 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `ACID`<br>**비교 피드백:** 트랜잭션의 상호 간섭 정도를 조절하는 4단계 격리 강도 설정은 Transaction Isolation Level입니다. |

---

## 4. 웹 기초 (HTML, CSS, JavaScript) (30선)

### 📌 JSON (JavaScript Object Notation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **JSON** |
| **공식 풀네임** | JavaScript Object Notation |
| **권장 발음** | 제이슨 (JSON) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZeI-s@n">JSON</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 웹 브라우저와 서버가 데이터를 주고받을 때 널리 쓰이는 가볍고 직관적인 `{키: 값}` 형태의 표준 텍스트 포맷 |
| **문맥 빈칸 예문** | "서버 REST API로부터 사용자 프로필 데이터를 클라이언트로 받아올 때 표준 경량 포맷인 {{JSON}} 문자열을 파싱한다." |
| **혼동 오답 피드백** | **오답 입력:** `XML`<br>**비교 피드백:** XML은 <tag> 기반의 복잡한 포맷이며, 현대 웹 API 통신의 표준 경량 포맷은 JSON입니다. |

### 📌 DOM (Document Object Model)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **DOM** |
| **공식 풀네임** | Document Object Model |
| **권장 발음** | 돔 (문서 객체 모델) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dAm">DOM</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 웹 브라우저가 HTML 문서를 읽어 태그와 속성들을 트리(Tree) 구조의 자바스크립트 객체로 모델링해 놓은 화면 제어 인터페이스 |
| **문맥 빈칸 예문** | "자바스크립트 `document.getElementById()`를 사용하여 화면의 특정 버튼 요소를 조작하려면 브라우저가 파싱한 {{DOM}} 트리에 접근해야 한다." |
| **혼동 오답 피드백** | **오답 입력:** `BOM`<br>**비교 피드백:** BOM은 브라우저 창 객체이며, HTML 문서 본문 요소를 트리로 표현한 모델은 DOM입니다. |

### 📌 Flexbox (CSS Flexible Box Layout)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Flexbox** |
| **공식 풀네임** | CSS Flexible Box Layout |
| **권장 발음** | 플렉스박스 (CSS 레이아웃) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="flEks-bAks">Flexbox</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 요소들을 가로(행) 또는 세로(열) 1차원 방향으로 유연하게 배치하고 정렬하며 남은 공간을 자동 분배하는 CSS 레이아웃 |
| **문맥 빈칸 예문** | "네비게이션 바 내부의 로고와 메뉴 버튼들을 가로로 나란히 배치하고 가운데 정렬하기 위해 `display: {{Flexbox}}` (flex)를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Grid`<br>**비교 피드백:** Grid는 2차원(행과 열 동시) 격자 레이아웃 시스템이며, 1차원 축 기반의 정렬은 Flexbox입니다. |

### 📌 Closure (JavaScript Closure)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Closure** |
| **공식 풀네임** | JavaScript Closure |
| **권장 발음** | 클로저 (Closure) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kloU-Z@r">Closure</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 외부 함수의 실행이 종료되어 Call Stack에서 사라진 후에도, 내부 함수가 자신이 선언되었을 때의 렉시컬 스코프 변수를 계속 기억하고 참조할 수 있는 현상 |
| **문맥 빈칸 예문** | "함수 외부에서 직접 수정할 수 없는 비공개(Private) 카운터 변수를 유지하기 위해 자바스크립트의 {{Closure}} 특성을 활용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Hoisting`<br>**비교 피드백:** 선언부가 최상단으로 올려지는 것은 Hoisting이며, 외부 스코프를 기억하는 함수는 Closure입니다. |

### 📌 Hoisting (JavaScript Hoisting)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Hoisting** |
| **공식 풀네임** | JavaScript Hoisting |
| **권장 발음** | 호이스팅 (Hoisting) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="hOIs-tIN">Hoisting</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 자바스크립트 엔진이 코드를 실행하기 전 변수 및 함수 선언부를 스코프의 최상단으로 먼저 끌어올려 메모리에 등록하는 현상 |
| **문맥 빈칸 예문** | "`var`로 선언된 변수가 선언문 이전 줄에서 호출되어도 에러가 안 나고 `undefined`가 출력되는 이유는 자바스크립트의 {{Hoisting}} 때문이다." |
| **혼동 오답 피드백** | **오답 입력:** `Closure`<br>**비교 피드백:** 선언부가 스코프 최상단으로 올려지는 자바스크립트 고유 현상은 Hoisting입니다. |

### 📌 Event Loop (JavaScript Event Loop)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Event Loop** |
| **공식 풀네임** | JavaScript Event Loop |
| **권장 발음** | 이벤트 루프 (Event Loop) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-vEnt lup">Event Loop</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 싱글 스레드인 자바스크립트에서 Call Stack이 비어있는지 확인하고, Task Queue에 대기 중인 비동기 콜백을 Call Stack으로 밀어 넣어 논블로킹을 실현하는 엔진 |
| **문맥 빈칸 예문** | "`setTimeout`이나 `fetch` 비동기 콜백 함수가 메인 스레드 실행을 방해하지 않고 순서대로 처리되도록 조율하는 핵심 메커니즘은 {{Event Loop}}이다." |
| **혼동 오답 피드백** | **오답 입력:** `Garbage Collector`<br>**비교 피드백:** 비동기 큐와 호출 스택을 순환 관리하는 것은 Event Loop입니다. |

### 📌 Promise (JavaScript Promise)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Promise** |
| **공식 풀네임** | JavaScript Promise |
| **권장 발음** | 프로미스 (비동기 객체) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="prA-mIs">Promise</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 자바스크립트 비동기 연산의 최종 완료(Resolved) 또는 실패(Rejected) 결과값을 담는 객체로, 콜백 지옥을 방지함 |
| **문맥 빈칸 예문** | "서버 통신 비동기 작업의 성공/실패 여부를 체이닝 문법(`.then()`, `.catch()`)으로 깔끔하게 처리하기 위해 {{Promise}} 객체를 반환받는다." |
| **혼동 오답 피드백** | **오답 입력:** `Callback`<br>**비교 피드백:** 비동기 상태를 캡슐화한 표준 객체는 Promise입니다. |

### 📌 Async/Await (async and await)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Async/Await** |
| **공식 풀네임** | async and await |
| **권장 발음** | 어싱크 / 어웨이트 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="eI-sINk @-weIt">Async Await</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Promise 기반의 비동기 코드를 마치 동기식 코드(절차적)처럼 직관적으로 읽고 쓸 수 있게 만든 자바스크립트 ES8 문법 설탕 |
| **문맥 빈칸 예문** | "복잡한 `.then()` 체이닝 대신 `try-catch` 문과 함께 직관적인 동기식 형태로 비동기 API를 호출하기 위해 `{{Async/Await}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Generator`<br>**비교 피드백:** Promise를 동기 코드처럼 읽기 쉽게 만드는 공식 문법은 Async/Await입니다. |

### 📌 Event Bubbling (Event Bubbling)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Event Bubbling** |
| **공식 풀네임** | Event Bubbling |
| **권장 발음** | 이벤트 버블링 (Event Bubbling) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-vEnt bV-blIN">Event Bubbling</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 자식 요소에서 이벤트가 발생했을 때 거품(Bubble)처럼 상위 부모 DOM 요소들로 이벤트가 연쇄적으로 전달되어 전파되는 현상 |
| **문맥 빈칸 예문** | "카드 내부의 버튼을 눌렀을 때 상위 카드 클릭 이벤트까지 연쇄 실행되는 것을 막기 위해 `e.stopPropagation()`으로 {{Event Bubbling}}을 차단했다." |
| **혼동 오답 피드백** | **오답 입력:** `Event Capturing`<br>**비교 피드백:** 자식에서 부모로 이벤트가 올라가는 것은 Event Bubbling입니다. |

### 📌 Semantic Tag (HTML5 Semantic Elements)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Semantic Tag** |
| **공식 풀네임** | HTML5 Semantic Elements |
| **권장 발음** | 시맨틱 태그 (의미론적 태그) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sI-m{n-tIk t{g">Semantic Tag</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `<div>`, `<span>`과 달리 `<header>`, `<nav>`, `<main>`, `<article>`처럼 태그 이름 자체에 콘텐츠의 의미와 구조를 명시한 HTML5 태그 |
| **문맥 빈칸 예문** | "검색엔진 최적화(SEO)와 스크린 리더의 웹 접근성을 높이기 위해 의미 없는 `div` 대신 `header`, `nav`, `section` 같은 {{Semantic Tag}}를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Meta Tag`<br>**비교 피드백:** 문서 본문 구조에 의미를 부여하는 태그는 Semantic Tag입니다. |

### 📌 localStorage (Web Storage API localStorage)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **localStorage** |
| **공식 풀네임** | Web Storage API localStorage |
| **권장 발음** | 로컬 스토리지 (localStorage) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="loU-k@l stO-rIdZ">localStorage</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 브라우저를 닫거나 컴퓨터를 재부팅해도 데이터가 영구히 보존되는 클라이언트 브라우저 전용 Key-Value 저장소 |
| **문맥 빈칸 예문** | "사용자의 다크 모드 테마 설정과 자동 로그인 프로필을 브라우저 재접속 시에도 유지하기 위해 {{localStorage}}에 JSON 문자열로 저장했다." |
| **혼동 오답 피드백** | **오답 입력:** `sessionStorage`<br>**비교 피드백:** 영구 유지되는 브라우저 저장소는 localStorage입니다. |

### 📌 CORS (Cross-Origin Resource Sharing)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **CORS** |
| **공식 풀네임** | Cross-Origin Resource Sharing |
| **권장 발음** | 코스 (교차 출처 리소스 공유) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kOrz">CORS</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 웹 브라우저의 보안 정책(SOP)을 넘어, 다른 출처(도메인, 포트, 프로토콜)의 백엔드 서버 자원에 접근할 수 있도록 허용하는 HTTP 헤더 기반 보안 메커니즘 |
| **문맥 빈칸 예문** | "Vue 프론트(5173 포트)에서 SpringBoot 백엔드(8080 포트) API를 호출할 때 브라우저 보안 차단을 해결하기 위해 서버에서 {{CORS}} 설정을 허용했다." |
| **혼동 오답 피드백** | **오답 입력:** `CSRF`<br>**비교 피드백:** 다른 출처 간 API 통신을 제어하는 표준 보안 정책은 CORS입니다. |

### 📌 Box Model (CSS Box Model)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Box Model** |
| **공식 풀네임** | CSS Box Model |
| **권장 발음** | 박스 모델 (CSS Box Model) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bAks mA-d@l">Box Model</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | HTML의 모든 요소를 사각형 상자로 보고 Content(내용), Padding(안쪽여백), Border(테두리), Margin(바깥여백)으로 공간을 계산하는 CSS 렌더링 규칙 |
| **문맥 빈칸 예문** | "패딩과 테두리가 추가되어도 요소의 전체 너비가 의도한 크기를 벗어나지 않도록 {{Box Model}}의 `box-sizing: border-box`를 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `Flexbox`<br>**비교 피드백:** 개별 요소의 내부/외부 여백과 테두리 공간 구조는 Box Model입니다. |

### 📌 CSS Grid (CSS Grid Layout (2D))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **CSS Grid** |
| **공식 풀네임** | CSS Grid Layout (2D) |
| **권장 발음** | 씨에스에스 그리드 (2차원 레이아웃) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="si-Es-Es grId">CSS Grid</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 가로 행(Row)과 세로 열(Column)을 동시에 제어하여 복잡한 반응형 카드 그리드나 대시보드 레이아웃을 손쉽게 만드는 2차원 CSS 시스템 |
| **문맥 빈칸 예문** | "대시보드의 9개 교재 카드를 3열 균등 격자로 나누고 간격을 주기 위해 `display: grid; {{CSS Grid}}` 속성을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Flexbox`<br>**비교 피드백:** 행과 열을 동시에 제어하는 2차원 레이아웃 시스템은 CSS Grid입니다. |

### 📌 BOM (Browser Object Model)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **BOM** |
| **공식 풀네임** | Browser Object Model |
| **권장 발음** | 봄 (브라우저 객체 모델) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bi-oU-Em">BOM</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 웹 브라우저 창 자체를 제어하기 위한 객체 모델로, `window`, `navigator`, `location`, `history`, `screen` 등을 제공 |
| **문맥 빈칸 예문** | "현재 웹 페이지의 URL 주소를 자바스크립트로 변경하거나 뒤로가기를 실행하기 위해 `window.location`, `window.history`의 {{BOM}} 객체를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `DOM`<br>**비교 피드백:** HTML 본문 요소를 조작하는 것은 DOM이고, 브라우저 창 자체를 제어하는 것은 BOM입니다. |

### 📌 Event Delegation (JavaScript Event Delegation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Event Delegation** |
| **공식 풀네임** | JavaScript Event Delegation |
| **권장 발음** | 이벤트 위임 (Event Delegation) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-vEnt dE-l@-geI-S@n">Event Delegation</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 수많은 자식 요소마다 일일이 클릭 리스너를 달지 않고, 상위 부모 요소에 단 하나의 이벤트 리스너를 달아 버블링을 통해 일괄 처리하는 패턴 |
| **문맥 빈칸 예문** | "동적으로 수백 개의 리스트 항목이 추가되어도 메모리 낭비 없이 이벤트를 감지하기 위해 부모 `<ul>`에 `{{Event Delegation}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Event Capturing`<br>**비교 피드백:** 상위 부모에 단일 리스너를 두고 버블링으로 하위 이벤트를 처리하는 패턴은 Event Delegation입니다. |

### 📌 preventDefault (Event.preventDefault())
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **preventDefault** |
| **공식 풀네임** | Event.preventDefault() |
| **권장 발음** | 프리벤트 디폴트 (기본 동작 취소) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="prI-vEnt dI-fOlt">preventDefault</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `<a>` 태그의 페이지 이동이나 `<form>` 태그의 새로고침 제출처럼 브라우저의 고유 기본 동작을 실행하지 않도록 차단하는 메서드 |
| **문맥 빈칸 예문** | "SPA 환경에서 폼 제출 시 브라우저가 새로고침되는 것을 막고 자바스크립트 비동기 처리를 위해 `e.{{preventDefault}}()`를 호출했다." |
| **혼동 오답 피드백** | **오답 입력:** `stopPropagation`<br>**비교 피드백:** stopPropagation은 상위로의 이벤트 버블링을 막고, 태그 본연의 기본 동작을 막는 것은 preventDefault입니다. |

### 📌 stopPropagation (Event.stopPropagation())
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **stopPropagation** |
| **공식 풀네임** | Event.stopPropagation() |
| **권장 발음** | 스탑 프로파게이션 (전파 중단) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="stAp prA-p@-geI-S@n">stopPropagation</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 이벤트가 상위 부모 노드로 계속해서 버블링(전파)되는 연쇄 호출 흐름을 그 자리에서 즉시 중단시키는 메서드 |
| **문맥 빈칸 예문** | "카드 안의 '좋아요' 버튼을 눌렀을 때 상위 카드의 전체 상세 열기 클릭 이벤트가 함께 트리거되지 않도록 `e.{{stopPropagation}}()`을 호출했다." |
| **혼동 오답 피드백** | **오답 입력:** `preventDefault`<br>**비교 피드백:** 태그 기본 동작 취소는 preventDefault이고, 상위로의 이벤트 전파를 차단하는 것은 stopPropagation입니다. |

### 📌 SessionStorage (Web Storage API sessionStorage)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **SessionStorage** |
| **공식 풀네임** | Web Storage API sessionStorage |
| **권장 발음** | 세션 스토리지 (sessionStorage) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sE-S@n stO-rIdZ">sessionStorage</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 브라우저 탭이나 창이 열려있는 동안에만 데이터가 유지되고, 해당 탭을 닫으면 즉시 모든 데이터가 삭제되는 임시 클라이언트 저장소 |
| **문맥 빈칸 예문** | "단일 결제 진행 단계 동안의 임시 폼 입력 데이터를 안전하게 유지하고 결제창을 닫으면 자동 폐기되도록 `{{SessionStorage}}`에 보관했다." |
| **혼동 오답 피드백** | **오답 입력:** `localStorage`<br>**비교 피드백:** 영구 보관은 localStorage이고, 브라우저 탭을 닫으면 즉시 삭제되는 임시 저장소는 SessionStorage입니다. |

### 📌 Fetch API (JavaScript Fetch API)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Fetch API** |
| **공식 풀네임** | JavaScript Fetch API |
| **권장 발음** | 페치 에이피아이 (Fetch API) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fEtS eI-pi-aI">Fetch API</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | XMLHttpRequest를 대체하여 자바스크립트 브라우저 환경에서 네트워크 비동기 HTTP 요청을 간결한 Promise 기반으로 수행하는 표준 내장 함수 |
| **문맥 빈칸 예문** | "외부 날씨 API 서버에 GET 요청을 보내고 JSON 응답 데이터를 받아오기 위해 브라우저 표준 `{{Fetch API}}`인 `fetch(url)`을 호출했다." |
| **혼동 오답 피드백** | **오답 입력:** `Ajax`<br>**비교 피드백:** Promise 기반의 현대 표준 브라우저 HTTP 요청 함수는 Fetch API입니다. |

### 📌 Axios (Axios HTTP Client)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Axios** |
| **공식 풀네임** | Axios HTTP Client |
| **권장 발음** | 액시오스 (Axios) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="{k-si-oUs">Axios</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 요청/응답 인터셉터, 자동 JSON 변환, 요청 취소, 에러 핸들링 기능을 제공하는 전 세계에서 가장 널리 쓰이는 비동기 HTTP 클라이언트 라이브러리 |
| **문맥 빈칸 예문** | "모든 API 요청에 JWT 토큰을 자동으로 헤더에 붙이고 응답 에러를 전역 처리하기 위해 `{{Axios}}` 인스턴스를 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Fetch`<br>**비교 피드백:** 자동 JSON 변환 및 인터셉터를 지원하는 인기 서드파티 라이브러리는 Axios입니다. |

### 📌 SOP (Same-Origin Policy)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **SOP** |
| **공식 풀네임** | Same-Origin Policy |
| **권장 발음** | 동일 출처 정책 (에스-오-피) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Es-oU-pi">SOP</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 어떤 출처(프로토콜, 호스트, 포트)에서 불러온 문서나 스크립트가 다른 출처의 리소스와 상호작용하는 것을 제한하는 브라우저 핵심 보안 정책 |
| **문맥 빈칸 예문** | "해커가 악성 스크립트로 다른 사이트의 개인정보에 접근하지 못하도록 웹 브라우저는 기본적으로 엄격한 `{{SOP}}`를 적용한다." |
| **혼동 오답 피드백** | **오답 입력:** `CORS`<br>**비교 피드백:** SOP는 다른 출처 접근을 차단하는 기본 브라우저 정책이며, 이를 허용해 주는 메커니즘은 CORS입니다. |

### 📌 IIFE (Immediately Invoked Function Expression)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **IIFE** |
| **공식 풀네임** | Immediately Invoked Function Expression |
| **권장 발음** | 즉시 실행 함수 (IIFE) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="aI-fi">IIFE</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 정의되자마자 즉시 실행되는 자바스크립트 함수 표현식 `(function() { ... })();`으로, 전역 스코프 오염을 방지하기 위해 사용됨 |
| **문맥 빈칸 예문** | "전역 변수 이름 충돌을 방지하고 독립된 로컬 스코프를 즉시 생성하기 위해 `(function() { ... })()` 형태의 `{{IIFE}}` 패턴을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Callback`<br>**비교 피드백:** 정의와 동시에 스스로 즉시 실행되는 함수 표현식은 IIFE입니다. |

### 📌 Prototype (JavaScript Prototype Inheritance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Prototype** |
| **공식 풀네임** | JavaScript Prototype Inheritance |
| **권장 발음** | 프로토타입 (원형 상속) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="proU-t@-taIp">Prototype</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 자바스크립트의 모든 객체가 부모 역할을 하는 프로토타입 객체로부터 메서드와 속성을 상속받아 공유하는 자바스크립트 고유의 상속 메커니즘 |
| **문맥 빈칸 예문** | "`Array.prototype.map`처럼 모든 배열 인스턴스가 공통 메서드를 메모리 낭비 없이 공유할 수 있는 것은 자바스크립트의 `{{Prototype}}` 체인 덕분이다." |
| **혼동 오답 피드백** | **오답 입력:** `Class`<br>**비교 피드백:** 클래스 문법 아래에서 실제로 자바스크립트 상속을 구현하는 핵심 메커니즘은 Prototype입니다. |

### 📌 Lexical Scope (JavaScript Lexical Scope)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Lexical Scope** |
| **공식 풀네임** | JavaScript Lexical Scope |
| **권장 발음** | 렉시컬 스코프 (정적 스코프) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lEk-sI-k@l skoUp">Lexical Scope</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 함수가 어디서 호출되었는지가 아니라, 소스코드 상에서 '어디에 선언(정의)되었는지'에 따라 상위 유효 범위가 정적으로 결정되는 스코프 규칙 |
| **문맥 빈칸 예문** | "함수가 실행되는 위치와 상관없이 선언된 위치의 부모 변수를 일관되게 참조할 수 있는 이유는 자바스크립트가 `{{Lexical Scope}}`를 따르기 때문이다." |
| **혼동 오답 피드백** | **오답 입력:** `Dynamic Scope`<br>**비교 피드백:** 호출 시점이 아닌 선언 시점에 결정되는 정적 스코프는 Lexical Scope입니다. |

### 📌 Microtask Queue (JavaScript Microtask Queue)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Microtask Queue** |
| **공식 풀네임** | JavaScript Microtask Queue |
| **권장 발음** | 마이크로태스크 큐 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="maI-kroU-t{sk kju">Microtask Queue</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 이벤트 루프에서 `Promise.then()`, `queueMicrotask` 콜백이 대기하는 큐로, 일반 Macrotask 큐(`setTimeout`)보다 항상 우선순위가 높아 먼저 처리됨 |
| **문맥 빈칸 예문** | "`setTimeout`과 `Promise.then`이 동시에 등록되었을 때 Promise 콜백이 먼저 실행되는 이유는 `{{Microtask Queue}}`의 우선순위가 더 높기 때문이다." |
| **혼동 오답 피드백** | **오답 입력:** `Macrotask Queue`<br>**비교 피드백:** Promise 콜백을 담는 높은 우선순위 비동기 큐는 Microtask Queue입니다. |

### 📌 Viewport (HTML meta viewport tag)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Viewport** |
| **공식 풀네임** | HTML meta viewport tag |
| **권장 발음** | 뷰포트 (Viewport) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vju-pOrt">Viewport</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 웹 페이지가 스마트폰, 태블릿 등 모바일 기기의 실제 화면 너비에 맞게 적절한 배율과 크기로 렌더링되도록 지정하는 HTML 메타 태그 |
| **문맥 빈칸 예문** | "모바일 브라우저에서 화면이 축소되지 않고 기기 폭 100%로 정상 반응형 렌더링되도록 `<meta name="{{Viewport}}" content="width=device-width, initial-scale=1.0">`을 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `Charset`<br>**비교 피드백:** 모바일 기기 화면 크기 배율을 지정하는 메타 설정은 Viewport입니다. |

### 📌 Media Query (CSS @media Rule)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **Media Query** |
| **공식 풀네임** | CSS @media Rule |
| **권장 발음** | 미디어 쿼리 (@media) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="mi-di-@ kwI-ri">Media Query</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 사용자 기기의 화면 너비(화면 폭), 해상도, 다크 모드 여부에 따라 서로 다른 CSS 스타일을 조건부로 적용하는 반응형 웹의 핵심 문법 |
| **문맥 빈칸 예문** | "스마트폰 화면(`max-width: 768px`)에서는 3열 그리드를 1열로 변경하여 한 손으로 보기 편하게 만들기 위해 `{{Media Query}}`를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Flexbox`<br>**비교 피드백:** 기기 화면 너비 조건에 따라 스타일을 분기하는 CSS 규칙은 Media Query입니다. |

### 📌 rem vs em (CSS Relative Units (rem, em))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **rem vs em** |
| **공식 풀네임** | CSS Relative Units (rem, em) |
| **권장 발음** | 알이엠 vs 이엠 (상대 단위) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rEm i-Em">rem em</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 루트 `<html>` 태그의 기본 글꼴 크기를 1배수로 삼는 `rem`과, 현재 요소의 부모 폰트 크기를 기준으로 삼는 `em` 단위 |
| **문맥 빈칸 예문** | "부모 요소의 중첩에 영향을 받지 않고 전체 웹사이트의 타이포그래피 비율을 일관되게 유지하기 위해 `{{rem vs em}}`의 rem 단위를 기본으로 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `px`<br>**비교 피드백:** px는 고정 절대 단위이며, 루트 html 폰트 기준 상대 단위는 rem입니다. |

### 📌 CSS Specificity (CSS Specificity Calculation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 4. 웹 기초 (HTML, CSS, JavaScript) (30선) |
| **용어 원형** | **CSS Specificity** |
| **공식 풀네임** | CSS Specificity Calculation |
| **권장 발음** | 명시도 (CSS 우선순위 가중치) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="spE-s@-fI-sI-ti">CSS Specificity</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 동일한 요소에 여러 CSS 규칙이 충돌할 때, `인라인 스타일(1000) > ID(100) > Class/가상클래스(10) > Tag(1)` 점수로 우선순위를 계산하는 규칙 |
| **문맥 빈칸 예문** | "클래스 선택자로 적용한 색상이 적용되지 않고 ID 선택자의 스타일이 덮어씌워지는 이유는 ID의 `{{CSS Specificity}}` 점수가 더 높기 때문이다." |
| **혼동 오답 피드백** | **오답 입력:** `Inheritance`<br>**비교 피드백:** 선택자 간의 우선순위 점수를 계산하는 CSS 규칙은 명시도(Specificity)입니다. |

---

## 5. 데이터 분석 개요 및 기초 통계 (30선)

### 📌 p-value (Probability Value (p-value))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **p-value** |
| **공식 풀네임** | Probability Value (p-value) |
| **권장 발음** | 피-값 (유의확률) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pi v{-lju">p-value</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 귀무가설이 맞다는 전제하에 관측된 결과가 단순 우연에 의해 발생했을 확률 (보통 $p < 0.05$일 때 유의미하다고 판정) |
| **문맥 빈칸 예문** | "신규 추천 알고리즘의 매출 증대 효과를 검증하는 A/B 테스트에서 {{p-value}}가 0.01로 산출되어 귀무가설을 기각했다." |
| **혼동 오답 피드백** | **오답 입력:** `Z-score`<br>**비교 피드백:** 가설검정에서 우연 발생 확률은 p-value입니다. |

### 📌 Normal Distribution (Normal Distribution (Gaussian))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Normal Distribution** |
| **공식 풀네임** | Normal Distribution (Gaussian) |
| **권장 발음** | 정규분포 (가우시안 분포) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="nOr-m@l dIs-trI-bju-S@n">Normal Distribution</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 평균을 중심으로 좌우가 완벽히 대칭인 종 모양의 연속 확률 분포로, 자연계와 사회 현상 데이터의 기본 분포 |
| **문맥 빈칸 예문** | "수험생 10만 명의 시험 점수 데이터는 평균 70점을 기준으로 좌우 대칭인 종 모양의 {{Normal Distribution}}을 형성하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Uniform Distribution`<br>**비교 피드백:** 평균 중심 종 모양의 대칭 분포는 Normal Distribution입니다. |

### 📌 Null Hypothesis (Null Hypothesis (H0))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Null Hypothesis** |
| **공식 풀네임** | Null Hypothesis (H0) |
| **권장 발음** | 귀무가설 (영가설, H0) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="nVl haI-pA-T@-sIs">Null Hypothesis</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 통계적 가설 검정에서 '효과가 없다', '차이가 없다'는 기본 전제로 세우고, 데이터를 통해 기각(부정)하고자 하는 가설 |
| **문맥 빈칸 예문** | "새로운 교육 프로그램이 이전과 비교해 '학습 성적에 아무런 차이가 없다'는 전제의 {{Null Hypothesis}}를 세우고 통계 검정을 시작했다." |
| **혼동 오답 피드백** | **오답 입력:** `Alternative Hypothesis`<br>**비교 피드백:** 기각 대상인 기본 전제 가설은 Null Hypothesis입니다. |

### 📌 ANOVA (Analysis of Variance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **ANOVA** |
| **공식 풀네임** | Analysis of Variance |
| **권장 발음** | 아노바 (분산분석) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="@-noU-v@">ANOVA</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 3개 이상의 집단 간 평균 차이가 유의미한지 집단 간 분산과 집단 내 분산의 비율(F-검정)을 통해 검증하는 통계 기법 |
| **문맥 빈칸 예문** | "SKALA 1기, 2기, 3기, 4기 등 4개 집단 간 평균 시험 점수에 유의미한 차이가 있는지 검정하기 위해 `{{ANOVA}}` 분석을 실시했다." |
| **혼동 오답 피드백** | **오답 입력:** `T-test`<br>**비교 피드백:** T-test는 2개 집단 비교용이며, 3개 이상 집단의 평균 비교는 ANOVA(분산분석)입니다. |

### 📌 Standard Deviation (Standard Deviation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Standard Deviation** |
| **공식 풀네임** | Standard Deviation |
| **권장 발음** | 표준편차 (시그마, SD) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="st{n-d@rd di-vi-eI-S@n">Standard Deviation</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터들이 평균값으로부터 얼마나 멀리 흩어져 있는지를 나타내는 산포도 지표로, 분산(Variance)의 양의 제곱근 |
| **문맥 빈칸 예문** | "두 반의 평균 점수는 80점으로 같지만, A반은 점수 격차가 커서 B반보다 {{Standard Deviation}} 수치가 훨씬 높게 나타났다." |
| **혼동 오답 피드백** | **오답 입력:** `Variance`<br>**비교 피드백:** 편차 제곱의 평균은 분산이며, 원래 단위로 복원한 양의 제곱근은 Standard Deviation입니다. |

### 📌 IQR (Interquartile Range)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **IQR** |
| **공식 풀네임** | Interquartile Range |
| **권장 발음** | 아이-큐-알 (사분위수 범위) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="aI-kju-A:r">IQR</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 데이터를 순서대로 정렬했을 때 75% 지점(Q3)에서 25% 지점(Q1)을 뺀 중앙 50% 구간의 범위로, 이상치 탐지의 핵심 기준 |
| **문맥 빈칸 예문** | "상자 수염 그림(Boxplot)에서 이상치를 판정할 때 $Q3 + 1.5 \times {{IQR}}$ 보다 큰 값을 기준으로 삼는다." |
| **혼동 오답 피드백** | **오답 입력:** `Standard Deviation`<br>**비교 피드백:** 중앙 50% 데이터의 산포도를 측정하는 이상치 기준 지표는 IQR입니다. |

### 📌 T-test (Student's t-test)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **T-test** |
| **공식 풀네임** | Student's t-test |
| **권장 발음** | 티-검정 (T-test) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ti-tEst">T-test</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 모집단의 분산을 모를 때, '두 집단' 간의 평균에 통계적으로 유의미한 차이가 있는지 검정하는 대표적인 가설 검정 기법 |
| **문맥 빈칸 예문** | "신약 투약 그룹과 위약 투약 그룹의 혈압 강하 효과 차이를 비교하기 위해 독립 표본 `{{T-test}}`를 실시했다." |
| **혼동 오답 피드백** | **오답 입력:** `ANOVA`<br>**비교 피드백:** 2개 집단 간 평균 비교는 T-test를 사용합니다. |

### 📌 Pearson Correlation (Pearson Correlation Coefficient)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Pearson Correlation** |
| **공식 풀네임** | Pearson Correlation Coefficient |
| **권장 발음** | 피어슨 상관계수 (r) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pIr-s@n kO-r@-leI-S@n">Pearson Correlation</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 두 연속형 변수 간의 '선형적 상관관계'의 강도와 방향을 -1부터 +1 사이의 값으로 나타내는 계수 |
| **문맥 빈칸 예문** | "공부 시간과 시험 점수 사이의 선형적 비례 관계를 수치화하기 위해 두 변수 간의 `{{Pearson Correlation}}`을 구하여 r=0.85를 얻었다." |
| **혼동 오답 피드백** | **오답 입력:** `Spearman Correlation`<br>**비교 피드백:** 연속형 수치의 선형 관계를 측정하는 것은 Pearson Correlation입니다. |

### 📌 Overfitting (Model Overfitting)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Overfitting** |
| **공식 풀네임** | Model Overfitting |
| **권장 발음** | 과적합 (오버피팅) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="oU-v@r-fI-tIN">Overfitting</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 머신러닝 모델이 학습 데이터에만 너무 지나치게 맞춰져서 훈련셋에서는 100%이지만 새 테스트셋에서는 성능이 급락하는 현상 |
| **문맥 빈칸 예문** | "훈련 데이터셋 정확도는 99%인데 검증셋 정확도가 60%로 급락하는 전형적인 {{Overfitting}} 현상을 방지하기 위해 규제를 추가했다." |
| **혼동 오답 피드백** | **오답 입력:** `Underfitting`<br>**비교 피드백:** 학습 데이터에만 과도하게 적응한 것은 Overfitting입니다. |

### 📌 Type I Error (Type I Error (alpha))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Type I Error** |
| **공식 풀네임** | Type I Error (alpha) |
| **권장 발음** | 1종 오류 (알파, 위양성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="taIp wVn E-r@r">Type I Error</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 실제로는 귀무가설이 참(효과 없음)인데도 잘못 판단하여 귀무가설을 기각해 버리는 오류 (False Positive) |
| **문맥 빈칸 예문** | "실제로는 죄가 없는 무고한 피고인에게 유죄 판결을 내리는 것은 통계적 가설검정에서 {{Type I Error}}에 해당한다." |
| **혼동 오답 피드백** | **오답 입력:** `Type II Error`<br>**비교 피드백:** 거짓 양성 판정 오류는 Type I Error입니다. |

### 📌 Central Limit Theorem (Central Limit Theorem (CLT))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Central Limit Theorem** |
| **공식 풀네임** | Central Limit Theorem (CLT) |
| **권장 발음** | 중심극한정리 (CLT) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sEn-tr@l lI-mIt Ti-@-r@m">Central Limit Theorem</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 모집단이 어떤 분포이든 관계없이 표본의 크기(n)가 충분히 크면(n ≥ 30), 표본평균들의 분포는 정규분포에 근사한다는 정리 |
| **문맥 빈칸 예문** | "모집단이 비대칭이더라도 충분한 크기의 표본을 반복 추출하면 표본평균이 정규분포를 따른다는 통계학의 근간 이론은 {{Central Limit Theorem}}이다." |
| **혼동 오답 피드백** | **오답 입력:** `Law of Large Numbers`<br>**비교 피드백:** 표본평균의 분포 형태를 설명하는 것은 Central Limit Theorem입니다. |

### 📌 Outlier (Statistical Outlier)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Outlier** |
| **공식 풀네임** | Statistical Outlier |
| **권장 발음** | 이상치 (아웃라이어) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="aUt-laI-@r">Outlier</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 대부분의 데이터가 모여있는 일반적인 패턴이나 범위를 크게 벗어나 비정상적으로 너무 크거나 작은 극단적인 관측치 |
| **문맥 빈칸 예문** | "평균 소득을 계산할 때 상위 0.001%의 극단적인 슈퍼 부자 데이터는 {{Outlier}}로 식별하여 전처리 단계에서 윈저라이징했다." |
| **혼동 오답 피드백** | **오답 입력:** `Missing Value`<br>**비교 피드백:** 정상 범위를 비정상적으로 벗어난 극단값은 Outlier입니다. |

### 📌 Population vs Sample (Population and Sample)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Population vs Sample** |
| **공식 풀네임** | Population and Sample |
| **권장 발음** | 모집단 vs 표본집단 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pA-pju-leI-S@n s{m-p@l">Population Sample</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 연구 대상이 되는 전체 집단인 모집단(Population)과, 현실적 제약으로 모집단에서 실제로 추출하여 조사하는 일부인 표본(Sample) |
| **문맥 빈칸 예문** | "전국 유권자 4,000만 명 전체(모집단)를 전수조사할 수 없으므로 무작위로 1,000명의 `{{Population vs Sample}}` 표본을 추출해 지지율을 조사했다." |
| **혼동 오답 피드백** | **오답 입력:** `Parameter vs Statistic`<br>**비교 피드백:** 조사 대상 전체와 추출된 부분 집단의 관계는 Population vs Sample입니다. |

### 📌 Descriptive Statistics (Descriptive Statistics)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Descriptive Statistics** |
| **공식 풀네임** | Descriptive Statistics |
| **권장 발음** | 기술통계 (데이터 요약) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dI-skrIp-tIv st@-tIs-tIks">Descriptive Statistics</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 수집한 데이터의 특성을 한눈에 파악할 수 있도록 평균, 중앙값, 표준편차 등의 수치 요약값이나 그래프로 정리하는 통계 분야 |
| **문맥 빈칸 예문** | "고객 데이터의 전반적인 특성을 파악하기 위해 Pandas의 `describe()` 함수를 사용하여 평균, 사분위수 등 `{{Descriptive Statistics}}` 수치를 확인했다." |
| **혼동 오답 피드백** | **오답 입력:** `Inferential Statistics`<br>**비교 피드백:** 데이터를 요약하고 정리하는 것은 Descriptive Statistics(기술통계)입니다. |

### 📌 Inferential Statistics (Inferential Statistics)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Inferential Statistics** |
| **공식 풀네임** | Inferential Statistics |
| **권장 발음** | 추론통계 (모집단 추정) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="In-f@-rEn-S@l st@-tIs-tIks">Inferential Statistics</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 수집된 표본 데이터의 정보를 바탕으로 미지의 모집단 특성(모수)을 확률적으로 추정하고 가설을 검정하는 통계 분야 |
| **문맥 빈칸 예문** | "표본 1,000명의 만족도 조사 결과를 토대로 전체 사용자 100만 명의 만족도를 신뢰구간 95%로 추정하는 통계는 `{{Inferential Statistics}}`이다." |
| **혼동 오답 피드백** | **오답 입력:** `Descriptive Statistics`<br>**비교 피드백:** 표본으로 모집단의 특성을 확률적으로 추론하는 것은 Inferential Statistics입니다. |

### 📌 Variance (Statistical Variance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Variance** |
| **공식 풀네임** | Statistical Variance |
| **권장 발음** | 분산 (편차 제곱의 평균) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vE-ri-@ns">Variance</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 각 데이터 값들이 평균으로부터 떨어진 거리(편차)를 제곱하여 모두 더한 뒤 데이터 개수로 나눈 산포도 지표 |
| **문맥 빈칸 예문** | "데이터들이 평균 주변에 얼마나 밀집해 있는지 또는 넓게 퍼져 있는지를 수치화하기 위해 편차의 제곱평균인 `{{Variance}}`를 계산했다." |
| **혼동 오답 피드백** | **오답 입력:** `Standard Deviation`<br>**비교 피드백:** 편차 제곱의 평균값은 Variance이며, 제곱근을 씌운 것은 Standard Deviation입니다. |

### 📌 Median (Median Value)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Median** |
| **공식 풀네임** | Median Value |
| **권장 발음** | 중앙값 (메디안) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="mi-di-@n">Median</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터를 크기 순서대로 정렬했을 때 정확히 정중앙(50%)에 위치하는 값으로, 극단적인 이상치에 영향을 받지 않는 대표값 |
| **문맥 빈칸 예문** | "소득 분포처럼 극단적인 억대 연봉자가 평균을 크게 왜곡할 때는 평균보다 `{{Median}}`(중앙값)이 더 신뢰할 수 있는 대표값이다." |
| **혼동 오답 피드백** | **오답 입력:** `Mean`<br>**비교 피드백:** 이상치에 왜곡되지 않고 정중앙에 위치하는 대표값은 Median입니다. |

### 📌 Mode (Statistical Mode)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Mode** |
| **공식 풀네임** | Statistical Mode |
| **권장 발음** | 최빈값 (모드) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="moUd">Mode</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터 세트에서 가장 빈번하게, 가장 많은 횟수로 나타난 값 (범주형 데이터의 대표값으로 주로 사용됨) |
| **문맥 빈칸 예문** | "쇼핑몰에서 고객들이 가장 많이 구매한 신발 사이즈(예: 260mm)를 파악하기 위해 범주 데이터의 `{{Mode}}`(최빈값)을 조회했다." |
| **혼동 오답 피드백** | **오답 입력:** `Median`<br>**비교 피드백:** 가장 자주 등장한 값은 Mode입니다. |

### 📌 Skewness (Statistical Skewness)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Skewness** |
| **공식 풀네임** | Statistical Skewness |
| **권장 발음** | 왜도 (비대칭도) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="skju-nIs">Skewness</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 데이터의 확률분포가 정규분포 대칭에서 벗어나 오른쪽 또는 왼쪽으로 얼마나 치우쳐 있는지를 나타내는 척도 |
| **문맥 빈칸 예문** | "오른쪽으로 꼬리가 길게 늘어진 소득 데이터는 양수(+)의 `{{Skewness}}` 값을 가지므로 로그 변환을 통해 정규분포화했다." |
| **혼동 오답 피드백** | **오답 입력:** `Kurtosis`<br>**비교 피드백:** 분포가 좌우로 기운 정도는 왜도(Skewness)이며, 뾰족한 정도는 첨도(Kurtosis)입니다. |

### 📌 Kurtosis (Statistical Kurtosis)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Kurtosis** |
| **공식 풀네임** | Statistical Kurtosis |
| **권장 발음** | 첨도 (뾰족도) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="k3:r-toU-sIs">Kurtosis</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 데이터의 확률분포가 정규분포에 비해 중심부가 얼마나 뾰족하게 솟아있고 양쪽 꼬리가 얼마나 두꺼운지를 나타내는 척도 |
| **문맥 빈칸 예문** | "금융 시장 수익률 데이터처럼 극단적인 이상치 위험(Fat-tail)이 큰 분포는 정규분포(첨도=3)보다 높은 `{{Kurtosis}}`를 보인다." |
| **혼동 오답 피드백** | **오답 입력:** `Skewness`<br>**비교 피드백:** 분포의 뾰족함과 꼬리의 두께를 나타내는 지표는 Kurtosis입니다. |

### 📌 Z-score (Standard Z-score)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Z-score** |
| **공식 풀네임** | Standard Z-score |
| **권장 발음** | 제트-점수 (표준화 점수) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="zEd skOr">Z-score</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 어떤 데이터 값이 평균으로부터 몇 표준편차만큼 떨어져 있는지를 나타내는 변환 값 `(X - Mean) / SD` |
| **문맥 빈칸 예문** | "서로 난이도가 다른 수학(평균 50)과 영어(평균 80) 시험 점수를 공정하게 비교하기 위해 두 과목의 점수를 `{{Z-score}}`로 표준화했다." |
| **혼동 오답 피드백** | **오답 입력:** `p-value`<br>**비교 피드백:** 평균에서 몇 표준편차 떨어져 있는지를 나타내는 표준화 수치는 Z-score입니다. |

### 📌 Type II Error (Type II Error (beta, False Negative))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Type II Error** |
| **공식 풀네임** | Type II Error (beta, False Negative) |
| **권장 발음** | 2종 오류 (베타, 위음성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="taIp tu E-r@r">Type II Error</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 실제로는 대립가설이 참(효과가 있음)인데도 연구자가 이를 놓치고 귀무가설을 채택해 버리는 오류 (위음성) |
| **문맥 빈칸 예문** | "실제로 질병에 걸린 환자에게 의사가 '정상입니다'라고 오진하여 치료 기회를 놓치는 것은 통계적으로 `{{Type II Error}}`에 해당한다." |
| **혼동 오답 피드백** | **오답 입력:** `Type I Error`<br>**비교 피드백:** 실제 효과가 있는데 없다고 놓치는 거짓 음성 오류는 Type II Error입니다. |

### 📌 Significance Level (Significance Level (alpha))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Significance Level** |
| **공식 풀네임** | Significance Level (alpha) |
| **권장 발음** | 유의수준 (알파, 0.05) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sIg-nI-fI-k@ns lE-v@l">Significance Level</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 귀무가설이 참일 때 이를 잘못 기각할 최대 허용 확률(1종 오류의 상한선)로, 학계와 업계에서 주로 $\alpha = 0.05$ (5%)를 기준으로 설정 |
| **문맥 빈칸 예문** | "신약 검정 가설검정을 수행하기 전 1종 오류 허용 한계인 `{{Significance Level}}`을 $\alpha = 0.05$로 사전 확정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Confidence Level`<br>**비교 피드백:** 1종 오류의 최대 허용 한계 확률 기준은 유의수준(Significance Level)입니다. |

### 📌 Chi-Square Test (Chi-Square Independence Test)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Chi-Square Test** |
| **공식 풀네임** | Chi-Square Independence Test |
| **권장 발음** | 카이제곱 검정 (독립성 검정) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kaI skwEr tEst">Chi-Square Test</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 성별(남/여)과 선호 정당(A/B/C)처럼 두 범주형(Categorical) 변수 간에 서로 독립인지 연관성이 있는지를 교차표로 검증하는 통계 기법 |
| **문맥 빈칸 예문** | "고객의 연령대(20대, 30대, 40대)와 주로 사용하는 결제 수단(카드, 간편결제) 간에 유의미한 연관성이 있는지 확인하기 위해 `{{Chi-Square Test}}`를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `T-test`<br>**비교 피드백:** T-test는 수치형 평균 비교용이며, 두 범주형 변수 간의 연관성 검정은 Chi-Square Test입니다. |

### 📌 Spearman Correlation (Spearman Rank Correlation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Spearman Correlation** |
| **공식 풀네임** | Spearman Rank Correlation |
| **권장 발음** | 스피어만 상관계수 (순위 상관) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="spIr-m@n kO-r@-leI-S@n">Spearman Correlation</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 데이터의 원시 수치 대신 '순위(Rank)'를 기반으로 비선형적 단조 증가/감소 관계를 측정하는 비모수적 상관계수 |
| **문맥 빈칸 예문** | "수치가 정규분포를 따르지 않고 극단적 이상치가 존재할 때 두 변수의 순위 기반 연관성을 측정하기 위해 `{{Spearman Correlation}}`을 산출했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pearson Correlation`<br>**비교 피드백:** 선형 연속형 상관은 Pearson이고, 순위 기반 비선형 단조 관계는 Spearman Correlation입니다. |

### 📌 Covariance (Statistical Covariance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Covariance** |
| **공식 풀네임** | Statistical Covariance |
| **권장 발음** | 공분산 (Covariance) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="koU-vE-ri-@ns">Covariance</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 두 변수가 함께 변화하는 경향성을 나타내는 지표로, 양수면 같은 방향으로, 음수면 반대 방향으로 움직임을 의미 (단위에 영향 받음) |
| **문맥 빈칸 예문** | "두 주식 종목의 주가가 같은 방향으로 동조화되어 움직이는지 파악하기 위해 두 자산 간의 `{{Covariance}}`를 계산했다." |
| **혼동 오답 피드백** | **오답 입력:** `Correlation`<br>**비교 피드백:** 단위에 영향을 받지 않도록 공분산을 -1~+1로 표준화한 지표가 상관계수(Correlation)입니다. |

### 📌 Linear Regression (Linear Regression Modeling)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Linear Regression** |
| **공식 풀네임** | Linear Regression Modeling |
| **권장 발음** | 선형 회귀 (Linear Regression) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lI-ni-@r rI-grE-S@n">Linear Regression</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 하나 이상의 독립 변수(X)와 연속형 종속 변수(Y) 간의 선형 관계식을 최소제곱법(OLS)으로 모델링하여 미래 값을 예측하는 기법 |
| **문맥 빈칸 예문** | "광고비 지출액(X)을 바탕으로 다음 달 예상 매출액(Y)을 예측하는 최적의 직선 방정식을 도출하기 위해 `{{Linear Regression}}` 모델을 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `Logistic Regression`<br>**비교 피드백:** 연속형 수치 Y를 예측하는 직선 모델은 Linear Regression입니다. |

### 📌 R-squared (Coefficient of Determination (R^2))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **R-squared** |
| **공식 풀네임** | Coefficient of Determination (R^2) |
| **권장 발음** | 결정계수 (알-스퀘어드, R2) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="A:r skwErd">R squared</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 회귀 모델이 종속 변수(Y)의 전체 변동성 중 몇 %를 설명하는지를 0부터 1 사이의 비율로 나타내는 회귀 모델 적합도 지표 |
| **문맥 빈칸 예문** | "부동산 가격 예측 회귀 모델의 설명력을 평가한 결과 `{{R-squared}}`가 0.85로 나와 모델이 데이터 변동의 85%를 잘 설명함을 확인했다." |
| **혼동 오답 피드백** | **오답 입력:** `p-value`<br>**비교 피드백:** 회귀 모델의 전체 분산 설명력 비율을 나타내는 지표는 결정계수(R-squared)입니다. |

### 📌 VIF (Variance Inflation Factor)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **VIF** |
| **공식 풀네임** | Variance Inflation Factor |
| **권장 발음** | 브이-아이-에프 (분산팽창지수) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi-aI-Ef">VIF</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 다중 회귀 분석에서 독립 변수들 간에 강한 상관관계가 존재하여 모델을 왜곡시키는 다중공선성(Multicollinearity)의 심각도를 측정하는 지수 |
| **문맥 빈칸 예문** | "회귀 모델에서 `{{VIF}}` 수치가 10 이상으로 치솟은 중복 설명 변수들을 식별하여 다중공선성을 해소하기 위해 제거했다." |
| **혼동 오답 피드백** | **오답 입력:** `p-value`<br>**비교 피드백:** 다중공선성 진단에 사용되는 핵심 지수는 VIF(Variance Inflation Factor)입니다. |

### 📌 Bias-Variance Tradeoff (Bias-Variance Tradeoff)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 5. 데이터 분석 개요 및 기초 통계 (30선) |
| **용어 원형** | **Bias-Variance Tradeoff** |
| **공식 풀네임** | Bias-Variance Tradeoff |
| **권장 발음** | 편향-분산 트레이드오프 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="baI-@s vE-ri-@ns treId-Of">Bias Variance Tradeoff</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 모델이 너무 단순하면 편향(Bias)이 커져 과소적합되고, 모델이 너무 복잡하면 분산(Variance)이 커져 과적합되는 상충 관계 |
| **문맥 빈칸 예문** | "머신러닝 모델의 복잡도를 최적화하여 총 일반화 오차를 최소화하는 균형점을 찾는 핵심 원리는 `{{Bias-Variance Tradeoff}}`이다." |
| **혼동 오답 피드백** | **오답 입력:** `Overfitting`<br>**비교 피드백:** 편향과 분산 간의 상충되는 오차 균형 관계를 나타내는 이론은 Bias-Variance Tradeoff입니다. |

---

## 6. 실전 Feature Engineering (30선)

### 📌 One-Hot Encoding (One-Hot Encoding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **One-Hot Encoding** |
| **공식 풀네임** | One-Hot Encoding |
| **권장 발음** | 원-핫 인코딩 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wVn hAt En-koU-dIN">One-Hot Encoding</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 범주형 문자열 데이터를 해당되는 값만 1, 나머지는 0으로 표현하는 독립적인 이진 벡터 컬럼들로 변환하는 기법 |
| **문맥 빈칸 예문** | "머신러닝 모델에 '직업'과 같은 문자열 범주형 특성을 입력하기 위해 각 항목을 0과 1의 독립적인 컬럼으로 변환하는 {{One-Hot Encoding}}을 수행하였다." |
| **혼동 오답 피드백** | **오답 입력:** `Label Encoding`<br>**비교 피드백:** 독립적인 0/1 열로 분리하는 기법은 One-Hot Encoding입니다. |

### 📌 StandardScaler (StandardScaler (Z-score Normalization))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **StandardScaler** |
| **공식 풀네임** | StandardScaler (Z-score Normalization) |
| **권장 발음** | 표준화 스케일러 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="st{n-d@rd skeI-l@r">StandardScaler</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 각 특성의 평균을 0, 표준편차를 1이 되도록 변환하여 정규분포 형태로 스케일을 맞추는 전처리 기법 |
| **문맥 빈칸 예문** | "서로 단위가 다른 '나이'와 '연봉' 컬럼의 평균을 0, 분산을 1로 일치시키기 위해 scikit-learn의 `{{StandardScaler}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `MinMaxScaler`<br>**비교 피드백:** 평균 0과 표준편차 1로 변환하는 것은 StandardScaler입니다. |

### 📌 MinMaxScaler (MinMaxScaler (Normalization))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **MinMaxScaler** |
| **공식 풀네임** | MinMaxScaler (Normalization) |
| **권장 발음** | 최소-최대 스케일러 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="mIn m{ks skeI-l@r">MinMaxScaler</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터의 최솟값을 0, 최댓값을 1로 변환하여 모든 데이터가 [0, 1] 구간 안에 들어오도록 정규화하는 기법 |
| **문맥 빈칸 예문** | "이미지 픽셀 값이나 점수 데이터를 [0, 1] 범위로 일정하게 압축하기 위해 `{{MinMaxScaler}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `StandardScaler`<br>**비교 피드백:** [0, 1] 고정 구간으로 압축하는 것은 MinMaxScaler입니다. |

### 📌 Label Encoding (Label Encoding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Label Encoding** |
| **공식 풀네임** | Label Encoding |
| **권장 발음** | 레이블 인코딩 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="leI-b@l En-koU-dIN">Label Encoding</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 범주형 문자열 데이터를 단순 정수값(0, 1, 2)으로 1:1 매핑하여 치환하는 인코딩 기법 (순서가 있는 범주에 적합) |
| **문맥 빈칸 예문** | "고객 등급([골드, 실버, 브론즈])처럼 명확한 서열 순서가 있는 데이터를 정수 2, 1, 0으로 변환하기 위해 `{{Label Encoding}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `One-Hot Encoding`<br>**비교 피드백:** 단일 컬럼에서 정수로 매핑하는 것은 Label Encoding입니다. |

### 📌 PCA (Principal Component Analysis)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **PCA** |
| **공식 풀네임** | Principal Component Analysis |
| **권장 발음** | 피-씨-에이 (주성분 분석) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pi-si-eI">PCA</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 고차원 데이터의 분산(정보)을 최대한 보존하면서 서로 직교하는 주성분 축을 찾아 저차원으로 압축하는 차원 축소 기법 |
| **문맥 빈칸 예문** | "100개의 특성을 가진 고차원 데이터를 정보 손실을 최소화하면서 2차원 평면에 시각화하기 위해 `{{PCA}}` 차원 축소를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `RFE`<br>**비교 피드백:** 기존 특성들을 결합해 새로운 저차원 축을 합성하는 것은 PCA입니다. |

### 📌 Imputation (Missing Value Imputation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Imputation** |
| **공식 풀네임** | Missing Value Imputation |
| **권장 발음** | 임퓨테이션 (결측치 대체) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Im-pju-teI-S@n">Imputation</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 데이터 수집 중 누락된 결측치를 단순히 삭제하지 않고 평균, 중앙값, 최빈값, 또는 머신러닝으로 채워 넣는 전처리 |
| **문맥 빈칸 예문** | "행을 삭제하면 데이터 손실이 크므로 '나이' 컬럼의 비어있는 결측치를 중앙값으로 채워 넣는 `{{Imputation}}` 처리를 진행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Trimming`<br>**비교 피드백:** 적절한 값으로 채워 넣는 것은 Imputation입니다. |

### 📌 Data Leakage (Data Leakage)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Data Leakage** |
| **공식 풀네임** | Data Leakage |
| **권장 발음** | 데이터 누수 (데이터 리키지) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="deI-t@ li-kIdZ">Data Leakage</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 학습 데이터셋을 만들 때 테스트 데이터셋의 정보나 미래의 타깃 정보가 전처리 과정에서 유입되어 모델이 과대평가되는 심각한 오류 |
| **문맥 빈칸 예문** | "전체 데이터에 StandardScaler를 먼저 fit한 후 train/test로 분할하면 테스트셋 정보가 흘러 들어가는 `{{Data Leakage}}`가 발생한다." |
| **혼동 오답 피드백** | **오답 입력:** `Overfitting`<br>**비교 피드백:** 테스트셋의 정보가 전처리 과정에서 학습셋에 부적절하게 유입되는 원인은 Data Leakage입니다. |

### 📌 RFE (Recursive Feature Elimination)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **RFE** |
| **공식 풀네임** | Recursive Feature Elimination |
| **권장 발음** | 알-에프-이 (재귀적 특성 제거) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="A:r-Ef-i">RFE</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 모든 특성으로 모델을 학습한 후 중요도가 가장 낮은 특성을 하나씩 반복적으로 제거해가며 최적 조합만을 남기는 기법 |
| **문맥 빈칸 예문** | "50개의 센서 변수 중 기여도가 가장 낮은 변수들을 순차 탈락시켜 최종 10개 핵심 변수만 선별하기 위해 `{{RFE}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `PCA`<br>**비교 피드백:** 원본 특성 중 덜 중요한 것을 제거하여 선별하는 것은 RFE입니다. |

### 📌 Target Encoding (Target Encoding (Mean Encoding))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Target Encoding** |
| **공식 풀네임** | Target Encoding (Mean Encoding) |
| **권장 발음** | 타깃 인코딩 (평균 인코딩) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tA:r-gEt En-koU-dIN">Target Encoding</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 범주형 변수의 각 카테고리를 해당 카테고리가 가진 정답(Target) 변수의 평균값으로 치환하는 강력한 인코딩 기법 |
| **문맥 빈칸 예문** | "1000개가 넘는 '우편번호' 범주를 원핫인코딩 대신 해당 우편번호 지역의 평균 집값으로 치환하는 `{{Target Encoding}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Label Encoding`<br>**비교 피드백:** 정답 Y값의 평균으로 매핑하는 것은 Target Encoding입니다. |

### 📌 Log Transformation (Log Transformation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Log Transformation** |
| **공식 풀네임** | Log Transformation |
| **권장 발음** | 로그 변환 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="lOg tr{ns-f@r-meI-S@n">Log Transformation</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 오른쪽으로 심하게 치우친 왜도를 가진 데이터에 자연로그 `np.log1p()`를 취해 정규분포에 가깝게 대칭으로 펴주는 수학적 변환 |
| **문맥 빈칸 예문** | "부동산 가격이나 소득 데이터처럼 오른쪽 꼬리가 매우 긴 극단적 분포를 정규분포 형태로 완화하기 위해 `{{Log Transformation}}`을 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `MinMax Scaling`<br>**비교 피드백:** 비대칭 분포 자체를 정규분포 모양으로 펴주는 것은 Log Transformation입니다. |

### 📌 Feature Importance (Feature Importance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Feature Importance** |
| **공식 풀네임** | Feature Importance |
| **권장 발음** | 특성 중요도 (피처 중요도) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fi-tS@r Im-pOr-t@ns">Feature Importance</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 의사결정나무나 랜덤포레스트 모델에서 타깃을 예측할 때 각 입력 특성이 불순도 감소에 얼마나 크게 기여했는지를 나타내는 점수 |
| **문맥 빈칸 예문** | "고객 이탈 예측 모델에서 어떤 변수가 가장 큰 영향을 미치는지 파악하기 위해 트리 모델의 `{{Feature Importance}}` 그래프를 시각화했다." |
| **혼동 오답 피드백** | **오답 입력:** `p-value`<br>**비교 피드백:** 머신러닝 트리 모델에서 각 특성의 예측 기여도를 나타내는 지표는 Feature Importance입니다. |

### 📌 Winsorization (Winsorization (Outlier Capping))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Winsorization** |
| **공식 풀네임** | Winsorization (Outlier Capping) |
| **권장 발음** | 윈저라이징 (이상치 캡핑) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wIn-z@-raI-zeI-S@n">Winsorization</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 이상치를 삭제하지 않고 상위 99% 초과 값은 99% 상한값으로, 하위 1% 미만 값은 1% 하한값으로 강제 치환하는 기법 |
| **문맥 빈칸 예문** | "극단적인 이상치를 데이터에서 제거하지 않고 상위 95% 분위수 값으로 상한을 제한하는 `{{Winsorization}}` 처리를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Trimming`<br>**비교 피드백:** 경계값으로 치환해 보존하는 기법은 Winsorization입니다. |

### 📌 RobustScaler (RobustScaler (IQR-based))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **RobustScaler** |
| **공식 풀네임** | RobustScaler (IQR-based) |
| **권장 발음** | 로버스트 스케일러 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="roU-bVst skeI-l@r">RobustScaler</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 평균과 표준편차 대신 중앙값(Median)과 사분위수 범위(IQR)를 사용하여 이상치의 영향에 매우 강건한 스케일러 |
| **문맥 빈칸 예문** | "극단적인 고소득 이상치가 포함된 금융 데이터에서 왜곡 없이 스케일링하기 위해 `{{RobustScaler}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `StandardScaler`<br>**비교 피드백:** 이상치에 민감한 StandardScaler와 달리 중앙값과 IQR을 사용하는 스케일러는 RobustScaler입니다. |

### 📌 MaxAbsScaler (MaxAbsScaler (Sparse Data))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **MaxAbsScaler** |
| **공식 풀네임** | MaxAbsScaler (Sparse Data) |
| **권장 발음** | 맥스앱스 스케일러 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="m{ks {bz skeI-l@r">MaxAbsScaler</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 각 특성의 절댓값 최댓값으로 나누어 데이터를 [-1, 1] 범위로 조정하며 0의 희소성(Sparsity)을 그대로 보존하는 스케일러 |
| **문맥 빈칸 예문** | "0이 대부분인 텍스트 TF-IDF 희소 행렬의 구조를 깨뜨리지 않고 스케일링하기 위해 `{{MaxAbsScaler}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `MinMaxScaler`<br>**비교 피드백:** 희소 행렬의 0 구조를 보존하며 최대 절댓값으로 나누는 스케일러는 MaxAbsScaler입니다. |

### 📌 Ordinal Encoding (Ordinal Encoding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Ordinal Encoding** |
| **공식 풀네임** | Ordinal Encoding |
| **권장 발음** | 순서형 인코딩 (Ordinal Encoding) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Or-dI-n@l En-koU-dIN">Ordinal Encoding</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | ['초등학교', '중학교', '고등학교', '대학교']처럼 범주 간에 명확한 위계 순서가 존재할 때 정수 순위를 부여하는 인코딩 |
| **문맥 빈칸 예문** | "학력 수준이나 설문 만족도([불만, 보통, 만족]) 같은 순서형 변수에 의미 있는 서열 숫자를 부여하기 위해 `{{Ordinal Encoding}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `One-Hot Encoding`<br>**비교 피드백:** 순서 관계를 보존하며 정수를 매핑하는 것은 Ordinal Encoding입니다. |

### 📌 Frequency Encoding (Frequency / Count Encoding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Frequency Encoding** |
| **공식 풀네임** | Frequency / Count Encoding |
| **권장 발음** | 빈도 인코딩 (Frequency Encoding) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fri-kw@n-si En-koU-dIN">Frequency Encoding</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 범주형 변수의 각 카테고리를 전체 데이터셋에서 해당 카테고리가 등장한 출현 빈도수(또는 백분율 비율)로 치환하는 기법 |
| **문맥 빈칸 예문** | "수만 개의 '자동차 모델명' 범주를 컬럼 폭증 없이 데이터 내 등장 빈도 비율로 변환하기 위해 `{{Frequency Encoding}}`을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Target Encoding`<br>**비교 피드백:** 정답 Y값이 아닌 단순 카테고리의 출현 빈도수로 인코딩하는 것은 Frequency Encoding입니다. |

### 📌 Binary Encoding (Binary Encoding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Binary Encoding** |
| **공식 풀네임** | Binary Encoding |
| **권장 발음** | 이진 인코딩 (Binary Encoding) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="baI-n@-ri En-koU-dIN">Binary Encoding</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 범주를 먼저 정수로 변환한 뒤 이를 이진수(Binary) 비트로 표현하여 컬럼 생성 개수를 대폭 줄이는 고차원 범주 인코딩 기법 |
| **문맥 빈칸 예문** | "카테고리가 1000개일 때 원핫인코딩의 1000개 컬럼 대신 단 10개의 비트 컬럼으로 압축 표현하기 위해 `{{Binary Encoding}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `One-Hot Encoding`<br>**비교 피드백:** 원핫인코딩의 차원 폭증을 방지하기 위해 이진 비트로 압축하는 기법은 Binary Encoding입니다. |

### 📌 Box-Cox Transformation (Box-Cox Power Transformation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Box-Cox Transformation** |
| **공식 풀네임** | Box-Cox Power Transformation |
| **권장 발음** | 박스-콕스 변환 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bAks kAks tr{ns-f@r-meI-S@n">Box-Cox</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 양수 데이터에 대해 최적의 거듭제곱 모수(람다 $\lambda$)를 찾아 비대칭 분포를 정규분포로 가장 완벽히 변환해 주는 지수 변환 기법 |
| **문맥 빈칸 예문** | "단순 로그 변환으로도 정규성을 만족하지 못하는 치우친 수치 변수에 최적의 거듭제곱 파라미터를 찾는 `{{Box-Cox Transformation}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Log Transformation`<br>**비교 피드백:** 최적의 람다 파라미터를 추정하여 정규분포화하는 일반화된 거듭제곱 변환은 Box-Cox Transformation입니다. |

### 📌 Trimming (Outlier Trimming (Truncation))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Trimming** |
| **공식 풀네임** | Outlier Trimming (Truncation) |
| **권장 발음** | 트리밍 (이상치 삭제) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="trI-mIN">Trimming</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 데이터셋에서 상위 1% 또는 하위 1%의 극단적인 이상치 행(Row)들을 보정 없이 완전히 잘라내어 삭제하는 기법 |
| **문맥 빈칸 예문** | "측정 센서 고장으로 발생한 명백한 에러 데이터 행들을 데이터프레임에서 완전히 제거하기 위해 `{{Trimming}}` 처리를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Winsorization`<br>**비교 피드백:** 경계값으로 치환하는 것은 Winsorization이며, 행 자체를 잘라내어 삭제하는 것은 Trimming입니다. |

### 📌 Variance Threshold (Variance Threshold Feature Selection)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Variance Threshold** |
| **공식 풀네임** | Variance Threshold Feature Selection |
| **권장 발음** | 분산 임계값 필터 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vE-ri-@ns TrE-SoUld">Variance Threshold</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 모든 행에서 거의 동일한 단 하나의 값만 가져서 분산(Variance)이 0에 가까운 무의미한 특성을 사전에 자동 제거하는 Filter 기법 |
| **문맥 빈칸 예문** | "모든 고객의 값이 '대한민국'으로 99.9% 동일한 무의미한 국적 컬럼을 사전에 걸러내기 위해 `{{Variance Threshold}}` 필터를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `RFE`<br>**비교 피드백:** 분산이 기준치 이하인 무정보 특성을 모델 학습 전 사전에 거르는 기법은 Variance Threshold입니다. |

### 📌 SelectKBest (Scikit-Learn SelectKBest)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **SelectKBest** |
| **공식 풀네임** | Scikit-Learn SelectKBest |
| **권장 발음** | 셀렉트 케이 베스트 (SelectKBest) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sI-lEkt keI bEst">SelectKBest</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 각 특성과 타깃 변수 간의 통계적 검정 점수(ANOVA F-값, 상호정보량 등)를 계산하여 가장 연관성이 높은 상위 K개 특성만 선택하는 기법 |
| **문맥 빈칸 예문** | "100개의 특성 중 타깃 예측 기여도 점수가 가장 높은 상위 20개 특성만을 선별하기 위해 scikit-learn의 `{{SelectKBest}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `RFE`<br>**비교 피드백:** 반복 모델링 없이 단변량 통계 점수 상위 K개를 즉시 뽑는 기법은 SelectKBest입니다. |

### 📌 Lasso (L1) (Lasso L1 Regularization)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Lasso (L1)** |
| **공식 풀네임** | Lasso L1 Regularization |
| **권장 발음** | 라쏘 (L1 규제) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="l{-soU El wVn">Lasso L1</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 회귀 계수의 절댓값 합에 페널티를 부여하여, 덜 중요한 특성의 가중치를 정확히 0으로 만들어 자동 특성 선택을 수행하는 L1 규제 |
| **문맥 빈칸 예문** | "불필요한 특성들의 가중치를 0으로 탈락시켜 모델을 가볍게 만들고 특성을 자동 선택하기 위해 `{{Lasso (L1)}}` 규제를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Ridge (L2)`<br>**비교 피드백:** 가중치를 0으로 만들어 특성을 제거하는 것은 Lasso(L1)이며, 가중치 크기만 줄이는 것은 Ridge(L2)입니다. |

### 📌 Ridge (L2) (Ridge L2 Regularization)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Ridge (L2)** |
| **공식 풀네임** | Ridge L2 Regularization |
| **권장 발음** | 릿지 (L2 규제) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rIdZ El tu">Ridge L2</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 회귀 계수의 제곱합에 페널티를 부여하여 가중치가 극단적으로 커지는 것을 억제하고 다중공선성을 완화하는 L2 규제 |
| **문맥 빈칸 예문** | "특성 간 상관성이 높아 가중치가 비정상적으로 폭증하는 것을 막고 일반화 성능을 높이기 위해 `{{Ridge (L2)}}` 회귀를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Lasso (L1)`<br>**비교 피드백:** 가중치를 0으로 만들지 않고 골고루 작게 유지하는 정규화 기법은 Ridge(L2)입니다. |

### 📌 ElasticNet (ElasticNet Regularization)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **ElasticNet** |
| **공식 풀네임** | ElasticNet Regularization |
| **권장 발음** | 엘라스틱넷 (L1+L2 결합 규제) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-l{s-tIk-nEt">ElasticNet</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | L1 규제(Lasso)의 변수 선택 능력과 L2 규제(Ridge)의 다중공선성 방어 능력을 선형 결합하여 장점만을 취한 정규화 기법 |
| **문맥 빈칸 예문** | "상관관계가 높은 여러 특성들이 함께 존재할 때 Lasso의 단점을 극복하고 안정적인 규제를 적용하기 위해 `{{ElasticNet}}`을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Lasso`<br>**비교 피드백:** L1과 L2 패널티를 혼합하여 최적화하는 정규화 모델은 ElasticNet입니다. |

### 📌 t-SNE (t-Distributed Stochastic Neighbor Embedding)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **t-SNE** |
| **공식 풀네임** | t-Distributed Stochastic Neighbor Embedding |
| **권장 발음** | 티-스니 (t-SNE) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ti sni">t-SNE</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 고차원 데이터 공간에서 가까운 이웃 데이터 간의 유사도를 보존하면서 복잡한 비선형 군집 구조를 2차원/3차원 평면에 시각화하는 기법 |
| **문맥 빈칸 예문** | "수백 차원의 이미지 임베딩 벡터들이 어떤 카테고리별로 군집을 형성하는지 2차원 산점도로 시각화하기 위해 `{{t-SNE}}`를 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `PCA`<br>**비교 피드백:** PCA는 선형 차원 축소이며, 비선형 이웃 관계를 유지하여 시각화에 탁월한 매니폴드 기법은 t-SNE입니다. |

### 📌 Permutation Importance (Permutation Feature Importance)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Permutation Importance** |
| **공식 풀네임** | Permutation Feature Importance |
| **권장 발음** | 순열 중요도 (Permutation Importance) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="p3:r-mju-teI-S@n">Permutation</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 모델 학습 후 특정 특성의 값들을 무작위로 뒤섞었을 때(셔플) 검증셋의 예측 성능이 얼마나 급락하는지를 측정하는 모델 비종속적 중요도 |
| **문맥 빈칸 예문** | "특정 피처의 데이터를 섞어 노이즈로 만들었을 때 모델 정확도가 얼마나 떨어지는지 측정하여 `{{Permutation Importance}}`를 평가했다." |
| **혼동 오답 피드백** | **오답 입력:** `Feature Importance`<br>**비교 피드백:** 트리 불순도 기반이 아닌, 검증셋의 값 셔플링 성능 하락으로 측정하는 신뢰성 높은 지표는 Permutation Importance입니다. |

### 📌 Target Leakage (Target Leakage in Features)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Target Leakage** |
| **공식 풀네임** | Target Leakage in Features |
| **권장 발음** | 타깃 누수 (Target Leakage) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tA:r-gEt li-kIdZ">Target Leakage</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 실제 예측 시점에는 절대 알 수 없고 결과(타깃)가 발생한 이후에나 측정 가능한 정보가 입력 특성으로 포함되는 치명적 오류 |
| **문맥 빈칸 예문** | "환자의 질병 발병 여부를 예측하는 모델에 '수술 후 입원 일수'처럼 결과 이후에 생기는 변수를 넣어버리는 치명적인 `{{Target Leakage}}`를 적발했다." |
| **혼동 오답 피드백** | **오답 입력:** `Data Leakage`<br>**비교 피드백:** 예측 시점에 미래에 발생할 타깃 정보가 변수로 유입되는 구체적 오류 형태를 Target Leakage라고 합니다. |

### 📌 Binning (Feature Binning (Discretization))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Binning** |
| **공식 풀네임** | Feature Binning (Discretization) |
| **권장 발음** | 구간화 (비닝, 이산화) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bI-nIN">Binning</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 연속형 수치 데이터(예: 나이 0~100세)를 몇 개의 의미 있는 범주형 구간(예: 유아, 청소년, 청년, 중장년, 노년)으로 묶는 전처리 기법 |
| **문맥 빈칸 예문** | "비선형적 패턴을 가진 '나이' 연속형 수치를 10대, 20대, 30대 등의 구간 범주로 나누기 위해 `pd.cut()`을 사용하여 `{{Binning}}`을 수행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Scaling`<br>**비교 피드백:** 수치 데이터를 범주형 구간으로 쪼개어 그룹화하는 기법은 Binning(구간화)입니다. |

### 📌 Polynomial Features (Polynomial Features Generation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Polynomial Features** |
| **공식 풀네임** | Polynomial Features Generation |
| **권장 발음** | 다항 특성 (Polynomial Features) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pA-lI-noU-mi-@l">Polynomial Features</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 기존 특성들의 거듭제곱($X^2, X^3$)과 교차곱($X_1 \times X_2$)을 새로 생성하여 선형 모델이 비선형 곡선 관계를 학습할 수 있게 만드는 기법 |
| **문맥 빈칸 예문** | "단순 선형 회귀 모델로 2차 곡선 형태의 데이터를 예측할 수 있도록 `{{Polynomial Features}}`를 적용해 특성을 2차 다항식으로 확장했다." |
| **혼동 오답 피드백** | **오답 입력:** `Log Transformation`<br>**비교 피드백:** 특성의 거듭제곱과 교차곱을 생성하여 비선형성을 부여하는 기법은 Polynomial Features입니다. |

### 📌 Interaction Term (Feature Interaction Terms)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 6. 실전 Feature Engineering (30선) |
| **용어 원형** | **Interaction Term** |
| **공식 풀네임** | Feature Interaction Terms |
| **권장 발음** | 상호작용 특성 (교차 특성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="In-t@r-{k-S@n t3:rm">Interaction Term</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 두 개 이상의 독립 변수가 결합할 때 발생하는 시너지 효과를 포착하기 위해 두 변수를 곱하거나 결합하여 만든 파생 변수 |
| **문맥 빈칸 예문** | "단독으로는 영향이 적지만 '기온'과 '습도'가 결합할 때 불쾌지수가 급증하는 현상을 모델에 반영하기 위해 두 변수의 교차곱인 `{{Interaction Term}}`을 생성했다." |
| **혼동 오답 피드백** | **오답 입력:** `One-Hot Encoding`<br>**비교 피드백:** 두 개 이상의 피처 간 시너지 관계를 표현하기 위해 결합한 파생 변수는 Interaction Term입니다. |

---

## 7. Java, SpringBoot, REST API 구현 (30선)

### 📌 .war (Web Application Archive (.war))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **.war** |
| **공식 풀네임** | Web Application Archive (.war) |
| **권장 발음** | 워 (Web Archive) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wOr">war</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 서블릿, JSP, HTML, JS 등 웹 애플리케이션 전체 구성 요소를 묶어 Tomcat 등의 웹 어플리케이션 서버(WAS)에 배포하기 위한 웹 전용 압축 패키지 |
| **문맥 빈칸 예문** | "독립적인 웹 서버(WAS) 환경에 풀스택 웹 애플리케이션 전체를 묶어 배포할 때 사용하는 자바 패키징 확장자는 {{.war}}이다." |
| **혼동 오답 피드백** | **오답 입력:** `.jar`<br>**비교 피드백:** jar는 일반 독립 자바 프로그램용이고, WAS 배포용은 war입니다. |

### 📌 DTO (Data Transfer Object)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **DTO** |
| **공식 풀네임** | Data Transfer Object |
| **권장 발음** | 디-티-오 (데이터 전송 객체) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-ti-oU">DTO</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 계층 간 데이터를 전달하기 위해 비즈니스 로직 없이 순수한 데이터 필드와 Getter/Setter만 담아놓은 바구니 객체 |
| **문맥 빈칸 예문** | "DB와 직접 매핑되는 Entity 객체가 외부에 노출되는 것을 방지하고 API 스펙에 맞는 데이터만 클라이언트에 응답하기 위해 {{DTO}} 객체로 변환하여 전달한다." |
| **혼동 오답 피드백** | **오답 입력:** `Entity`<br>**비교 피드백:** 계층 간 데이터 교환을 위한 순수 데이터 바구니 객체는 DTO입니다. |

### 📌 IoC / DI (Inversion of Control and Dependency Injection)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **IoC / DI** |
| **공식 풀네임** | Inversion of Control and Dependency Injection |
| **권장 발음** | 아이-오-씨 / 디-아이 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="aI-oU-si di-aI">IoC DI</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 개발자가 직접 `new`로 객체를 생성하지 않고, 스프링 컨테이너가 객체의 생명주기를 관리하며 의존성을 자동으로 주입해 주는 핵심 철학 |
| **문맥 빈칸 예문** | "객체 간 결합도를 낮추고 테스트 용이성을 극대화하기 위해 `new` 대신 스프링의 `@Autowired` 기반 `{{IoC / DI}}` 방식을 사용한다." |
| **혼동 오답 피드백** | **오답 입력:** `AOP`<br>**비교 피드백:** 스프링의 객체 제어권 역전 및 의존성 주입 메커니즘은 IoC / DI입니다. |

### 📌 Entity (JPA Entity)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Entity** |
| **공식 풀네임** | JPA Entity |
| **권장 발음** | 엔티티 (JPA 테이블 매핑 객체) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="En-tI-ti">Entity</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 데이터베이스 테이블과 1:1로 매핑되는 자바 클래스로, `@Id` 기본키와 컬럼 필드를 정의하여 데이터베이스 영속성을 관리하는 객체 |
| **문맥 빈칸 예문** | "`@Entity`와 `@Table(name = "users")` 어노테이션을 사용하여 실제 DB의 `users` 테이블 구조와 1:1로 매핑되는 {{Entity}} 클래스를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `DTO`<br>**비교 피드백:** DB 테이블과 직접 1:1 매핑되어 영속성을 갖는 객체는 Entity입니다. |

### 📌 Spring Bean (Spring Bean)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Spring Bean** |
| **공식 풀네임** | Spring Bean |
| **권장 발음** | 스프링 빈 (IoC 관리 객체) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprIN bin">Spring Bean</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 스프링 IoC 컨테이너에 의해 인스턴스화되고, 의존성이 주입되며 생명주기 전체가 관리되는 자바 객체 (기본 싱글톤) |
| **문맥 빈칸 예문** | "`@Component`, `@Service`, `@Repository` 어노테이션이 붙은 클래스는 스프링 부트 실행 시 컨테이너에 싱글톤 형태의 `{{Spring Bean}}`으로 등록된다." |
| **혼동 오답 피드백** | **오답 입력:** `POJO`<br>**비교 피드백:** 스프링 컨테이너에 의해 관리되는 객체는 Spring Bean입니다. |

### 📌 REST API (Representational State Transfer API)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **REST API** |
| **공식 풀네임** | Representational State Transfer API |
| **권장 발음** | 레스트 에이피아이 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rEst eI-pi-aI">REST API</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | HTTP URI로 자원을 명시하고, HTTP Method(GET, POST, PUT, DELETE)로 행위를 정의하여 JSON으로 데이터를 주고받는 아키텍처 |
| **문맥 빈칸 예문** | "클라이언트와 서버가 무상태 통신을 유지하며 표준 HTTP 메서드로 자원을 CRUD 조작할 수 있도록 {{REST API}}를 설계했다." |
| **혼동 오답 피드백** | **오답 입력:** `SOAP`<br>**비교 피드백:** HTTP 표준 메서드와 JSON을 활용하는 경량 아키텍처 스타일은 REST API입니다. |

### 📌 JPA / Hibernate (Java Persistence API and Hibernate)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **JPA / Hibernate** |
| **공식 풀네임** | Java Persistence API and Hibernate |
| **권장 발음** | 제이피에이 / 하이버네이트 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZeI-pi-eI haI-b@r-neIt">JPA Hibernate</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | SQL 쿼리를 직접 작성하지 않고도 자바 객체와 RDBMS 테이블을 자동으로 매핑(ORM)하여 데이터를 영속화해 주는 표준 스펙 및 구현체 |
| **문맥 빈칸 예문** | "복잡한 SQL 작성 부담을 줄이고 객체지향적인 패러다임으로 데이터베이스를 다루기 위해 자바 ORM 표준인 `{{JPA / Hibernate}}`를 도입했다." |
| **혼동 오답 피드백** | **오답 입력:** `MyBatis`<br>**비교 피드백:** 객체와 테이블 자체를 1:1 매핑하는 자바 표준 ORM은 JPA / Hibernate입니다. |

### 📌 @Transactional (Spring @Transactional Annotation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **@Transactional** |
| **공식 풀네임** | Spring @Transactional Annotation |
| **권장 발음** | 트랜잭셔널 어노테이션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="tr{n-z{k-S@-n@l">Transactional</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 메서드 내의 데이터베이스 작업들을 하나의 트랜잭션으로 묶어, 오류 발생 시 자동으로 전체 롤백하고 성공 시 커밋하는 어노테이션 |
| **문맥 빈칸 예문** | "주문 결제와 포인트 차감 작업 중 하나라도 예외가 발생하면 전체 DB 작업을 자동으로 롤백시키기 위해 서비스 메서드에 `{{@Transactional}}`을 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `@Async`<br>**비교 피드백:** DB 트랜잭션의 원자성을 보장하는 것은 @Transactional입니다. |

### 📌 N+1 Problem (JPA N+1 Query Problem)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **N+1 Problem** |
| **공식 풀네임** | JPA N+1 Query Problem |
| **권장 발음** | 엔 플러스 일 문제 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="En plVs wVn prA-bl@m">N plus one</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 1번의 쿼리로 N개의 부모 데이터를 조회했을 때 연관된 자식 데이터를 조회하기 위해 추가로 N번의 쿼리가 반복 실행되는 병목 현상 |
| **문맥 빈칸 예문** | "100명의 회원 목록을 조회할 때 각 회원의 주문 목록을 가져오기 위해 100번의 추가 SELECT 쿼리가 나가는 `{{N+1 Problem}}`을 해결하기 위해 `fetch join`을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Deadlock`<br>**비교 피드백:** 연관 엔티티 조회 시 쿼리가 폭증하는 JPA 성능 문제는 N+1 Problem입니다. |

### 📌 SOLID (SOLID Principles of OOP)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **SOLID** |
| **공식 풀네임** | SOLID Principles of OOP |
| **권장 발음** | 솔리드 (객체지향 5대 설계 원칙) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sA-lId">SOLID</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 단일책임(SRP), 개방폐쇄(OCP), 리스코프치환(LSP), 인터페이스분리(ISP), 의존역전(DIP)의 객체지향 5대 설계 원칙 |
| **문맥 빈칸 예문** | "소프트웨어가 변경에는 닫혀 있고 확장에는 열려 있도록(OCP) 유지보수성이 뛰어난 코드를 작성하기 위해 객체지향 `{{SOLID}}` 원칙을 준수했다." |
| **혼동 오답 피드백** | **오답 입력:** `DRY`<br>**비교 피드백:** 객체지향 소프트웨어 설계의 5대 핵심 원칙은 SOLID입니다. |

### 📌 JVM / GC (Java Virtual Machine and GC)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **JVM / GC** |
| **공식 풀네임** | Java Virtual Machine and GC |
| **권장 발음** | 제이-브이-엠 / 가비지 컬렉터 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZeI-vi-Em dZi-si">JVM GC</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 자바 바이트코드를 OS에 맞게 실행하는 가상머신과, 힙 메모리에서 참조되지 않는 불필요한 객체를 자동으로 해제하는 메모리 관리자 |
| **문맥 빈칸 예문** | "자바 프로그램이 '한 번 작성하면 어디서든 실행(WORA)'될 수 있는 것은 {{JVM / GC}}가 바이트코드를 실행하고 메모리를 자동 관리해주기 때문이다." |
| **혼동 오답 피드백** | **오답 입력:** `JDK`<br>**비교 피드백:** 바이트코드 실행과 메모리 회수를 담당하는 런타임 엔진은 JVM / GC입니다. |

### 📌 BCrypt (BCrypt Password Hashing)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **BCrypt** |
| **공식 풀네임** | BCrypt Password Hashing |
| **권장 발음** | 비크립트 (단방향 해시) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bi-krIpt">BCrypt</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | Salting과 Key Stretching을 적용하여 레인보우 테이블 공격을 무력화하는 강력한 비밀번호 단방향 암호화 알고리즘 |
| **문맥 빈칸 예문** | "사용자의 평문 비밀번호가 데이터베이스에 그대로 유출되지 않도록 Spring Security의 `{{BCrypt}}PasswordEncoder`로 단방향 해싱하여 저장했다." |
| **혼동 오답 피드백** | **오답 입력:** `AES-256`<br>**비교 피드백:** 비밀번호처럼 복호화가 불가능해야 하는 단방향 해시는 BCrypt를 사용합니다. |

### 📌 Interceptor (Spring HandlerInterceptor)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Interceptor** |
| **공식 풀네임** | Spring HandlerInterceptor |
| **권장 발음** | 인터셉터 (스프링 요청 가로채기) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="In-t@r-sEp-t@r">Interceptor</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 클라이언트의 HTTP 요청이 DispatcherServlet을 거쳐 실제 Controller에 도달하기 전/후에 로그인 인증이나 로깅을 가로채서 처리하는 컴포넌트 |
| **문맥 빈칸 예문** | "모든 API 컨트롤러 진입 전 JWT 토큰의 유효성을 검증하고 접근 권한을 일괄 확인하기 위해 스프링 `{{Interceptor}}`를 등록했다." |
| **혼동 오답 피드백** | **오답 입력:** `Filter`<br>**비교 피드백:** Spring Context 내부에서 Controller 직전에 가로채는 것은 Interceptor입니다. |

### 📌 .jar (Java Archive (.jar))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **.jar** |
| **공식 풀네임** | Java Archive (.jar) |
| **권장 발음** | 자르 (JAR 압축 파일) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZA:r">jar</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 스프링 부트의 기본 패키징 방식으로, 내장 톰캣(WAS)과 모든 의존성 라이브러리를 하나로 묶어 `java -jar app.jar`로 단독 실행 가능한 파일 |
| **문맥 빈칸 예문** | "별도의 외장 톰캣 서버 설치 없이 명령어 한 줄로 즉시 독립 실행되는 경량 마이크로서비스 배포본을 만들기 위해 `{{.jar}}`로 빌드했다." |
| **혼동 오답 피드백** | **오답 입력:** `.war`<br>**비교 피드백:** 내장 톰캣을 포함해 독립 실행되는 단독 실행 압축 파일은 jar입니다. |

### 📌 ApplicationContext (Spring ApplicationContext)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **ApplicationContext** |
| **공식 풀네임** | Spring ApplicationContext |
| **권장 발음** | 애플리케이션 컨텍스트 (스프링 컨테이너) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="{-plI-keI-S@n kAn-tEkst">ApplicationContext</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 스프링 프레임워크의 최상위 IoC 컨테이너 인터페이스로, 빈의 생성/조회/의존성 주입뿐 아니라 이벤트 발행, 국제화(i18n)를 총괄 |
| **문맥 빈칸 예문** | "스프링 애플리케이션이 기동될 때 모든 컴포넌트를 스캔하고 객체 생명주기를 총괄 관리하는 중앙 컨테이너는 `{{ApplicationContext}}`이다." |
| **혼동 오답 피드백** | **오답 입력:** `BeanFactory`<br>**비교 피드백:** BeanFactory의 기능을 확장하여 엔터프라이즈 부가 기능을 모두 제공하는 스프링의 메인 컨테이너는 ApplicationContext입니다. |

### 📌 Bean Scope (Spring Bean Scopes)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Bean Scope** |
| **공식 풀네임** | Spring Bean Scopes |
| **권장 발음** | 빈 스코프 (생명주기 범위) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="bin skoUp">Bean Scope</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 스프링 빈이 생성되어 유지되는 범위로, 기본값인 싱글톤(Singleton)과 요청마다 새로 생성되는 프로토타입(Prototype), Request, Session 등이 존재 |
| **문맥 빈칸 예문** | "스프링 컨테이너 내에서 빈 객체가 단 하나만 생성되어 애플리케이션 전체에서 공유되는 기본 `{{Bean Scope}}`는 싱글톤이다." |
| **혼동 오답 피드백** | **오답 입력:** `Garbage Collection`<br>**비교 피드백:** 스프링 빈의 인스턴스 생성 및 유지 범위를 결정하는 설정은 Bean Scope입니다. |

### 📌 @RestController (Spring @RestController)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **@RestController** |
| **공식 풀네임** | Spring @RestController |
| **권장 발음** | 레스트 컨트롤러 어노테이션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rEst k@n-troU-l@r">RestController</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `@Controller`와 `@ResponseBody`가 결합되어, HTML 뷰 페이지 대신 메서드의 반환 객체를 JSON/XML 데이터 본문으로 즉시 응답하는 어노테이션 |
| **문맥 빈칸 예문** | "Vue 프론트엔드와 JSON 형식으로 순수 API 통신을 전담하는 백엔드 엔드포인트를 만들기 위해 컨트롤러 클래스에 `{{@RestController}}`를 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `@Controller`<br>**비교 피드백:** @Controller는 주로 HTML 뷰 이름을 반환하고, JSON 데이터를 직접 반환하는 REST 전용 어노테이션은 @RestController입니다. |

### 📌 @Autowired (Spring @Autowired Annotation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **@Autowired** |
| **공식 풀네임** | Spring @Autowired Annotation |
| **권장 발음** | 오토와이어드 어노테이션 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="O-toU-waI-@rd">Autowired</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 스프링 컨테이너에 등록된 빈 중 타입(Type)이 일치하는 의존성 객체를 찾아 생성자나 필드에 자동으로 주입해 주는 어노테이션 |
| **문맥 빈칸 예문** | "Controller가 비즈니스 로직을 처리하는 UserService 객체를 스프링 컨테이너로부터 자동 주입받기 위해 생성자에 `{{@Autowired}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `@Component`<br>**비교 피드백:** @Component는 빈으로 등록하는 어노테이션이며, 등록된 빈을 주입받는 어노테이션은 @Autowired입니다. |

### 📌 Layered Architecture (Layered Architecture Pattern)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Layered Architecture** |
| **공식 풀네임** | Layered Architecture Pattern |
| **권장 발음** | 계층형 아키텍처 (Controller-Service-Repository) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="leI-@rd A:r-kI-tEk-tS@r">Layered Architecture</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 소프트웨어를 Presentation(컨트롤러), Business(서비스), Persistence(리포지토리), Database 4개 계층으로 명확히 분리하여 책임과 결합도를 관리하는 패턴 |
| **문맥 빈칸 예문** | "UI 요청 접수, 핵심 비즈니스 로직, 데이터베이스 영속성 조작의 책임을 명확히 격리하기 위해 전통적인 `{{Layered Architecture}}`를 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `Monolithic`<br>**비교 피드백:** 관심사 분리를 위해 컨트롤러-서비스-리포지토리 계층으로 구조화하는 패턴은 Layered Architecture입니다. |

### 📌 DAO / Repository (Data Access Object and Repository)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **DAO / Repository** |
| **공식 풀네임** | Data Access Object and Repository |
| **권장 발음** | 다오 / 리포지토리 (영속 계층) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="di-eI-oU rI-pA-zI-tO-ri">DAO Repository</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 실제 데이터베이스에 접근하여 CRUD 쿼리를 수행하는 영속성 계층의 인터페이스로, 비즈니스 로직과 DB 접근 기술을 완전히 분리해 주는 패턴 |
| **문맥 빈칸 예문** | "Service 계층이 구체적인 SQL 쿼리나 DB 종류에 종속되지 않고 데이터베이스 조작을 수행할 수 있도록 `{{DAO / Repository}}` 인터페이스를 두었다." |
| **혼동 오답 피드백** | **오답 입력:** `DTO`<br>**비교 피드백:** DTO는 화면 전달용 데이터 객체이며, 실제 DB 접근 및 쿼리를 캡슐화한 계층은 DAO / Repository입니다. |

### 📌 Spring Data JPA (Spring Data JPA Repository)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Spring Data JPA** |
| **공식 풀네임** | Spring Data JPA Repository |
| **권장 발음** | 스프링 데이터 제이피에이 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprIN deI-t@ dZeI-pi-eI">Spring Data JPA</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | `JpaRepository<User, Long>` 인터페이스를 상속받는 것만으로 기본적인 CRUD 및 페이징 메서드를 스프링이 구현체 없이 자동으로 런타임에 생성해 주는 프레임워크 |
| **문맥 빈칸 예문** | "반복적인 CRUD DAO 코드를 전혀 작성하지 않고 메서드 이름 규칙(`findByEmail`)만으로 자동 쿼리를 실행하기 위해 `{{Spring Data JPA}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Hibernate`<br>**비교 피드백:** Hibernate는 JPA의 구현체 ORM 엔진이며, 인터페이스 선언만으로 CRUD 메서드를 자동 생성해 주는 스프링 모듈은 Spring Data JPA입니다. |

### 📌 Lazy Loading (JPA Lazy Loading (FetchType.LAZY))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Lazy Loading** |
| **공식 풀네임** | JPA Lazy Loading (FetchType.LAZY) |
| **권장 발음** | 지연 로딩 (레이지 로딩) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="leI-zi loU-dIN">Lazy Loading</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 연관된 자식 엔티티를 즉시 DB에서 조회하지 않고 가짜 프록시(Proxy) 객체로 채워두었다가, 실제로 그 객체를 사용하는 시점에 쿼리를 날리는 최적화 기법 |
| **문맥 빈칸 예문** | "불필요한 조인 쿼리로 인한 성능 저하를 막기 위해 일대다(@OneToMany) 연관관계의 기본 패치 전략을 `{{Lazy Loading}}`으로 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Eager Loading`<br>**비교 피드백:** 자식 엔티티를 실제로 접근할 때까지 조회를 미루는 기법은 Lazy Loading입니다. |

### 📌 Eager Loading (JPA Eager Loading (FetchType.EAGER))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Eager Loading** |
| **공식 풀네임** | JPA Eager Loading (FetchType.EAGER) |
| **권장 발음** | 즉시 로딩 (이거 로딩) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="i-g@r loU-dIN">Eager Loading</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 부모 엔티티를 조회할 때 연관된 모든 자식 엔티티들을 무조건 처음부터 JOIN 쿼리를 통해 한 번에 전부 가져오는 로딩 전략 (N+1 문제 주원인) |
| **문맥 빈칸 예문** | "회원 단건을 조회할 때 회원이 작성한 1만 건의 게시글까지 무조건 한 번에 긁어오는 `{{Eager Loading}}` 전략은 N+1 병목을 유발하므로 지양해야 한다." |
| **혼동 오답 피드백** | **오답 입력:** `Lazy Loading`<br>**비교 피드백:** 부모 조회 시 자식까지 무조건 즉시 가져오는 전략은 Eager Loading입니다. |

### 📌 HTTP Methods (HTTP Request Methods)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **HTTP Methods** |
| **공식 풀네임** | HTTP Request Methods |
| **권장 발음** | 에이치티티피 메서드 (GET, POST, PUT, DELETE) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="eItS-ti-ti-pi mE-T@dz">HTTP Methods</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 클라이언트가 서버에 요청의 목적과 행위를 알리는 표준 프로토콜 동사: GET(조회), POST(생성), PUT(전체수정), PATCH(일부수정), DELETE(삭제) |
| **문맥 빈칸 예문** | "RESTful 원칙을 준수하기 위해 단어 목록 조회는 GET, 신규 단어 등록은 POST, 삭제는 DELETE의 `{{HTTP Methods}}`로 분기했다." |
| **혼동 오답 피드백** | **오답 입력:** `HTTP Status`<br>**비교 피드백:** 클라이언트가 서버에 수행하고자 하는 행위를 나타내는 동사는 HTTP Methods입니다. |

### 📌 HTTP Status Code (HTTP Response Status Codes)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **HTTP Status Code** |
| **공식 풀네임** | HTTP Response Status Codes |
| **권장 발음** | 에이치티티피 상태 코드 (200, 400, 500) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="st{-t@s koUd">HTTP Status Code</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 서버가 클라이언트의 요청을 처리한 결과를 3자리 숫자로 알리는 표준 코드: 200(성공), 201(생성됨), 400(잘못된요청), 401(미인증), 404(없음), 500(서버에러) |
| **문맥 빈칸 예문** | "회원가입 요청이 성공적으로 완료되어 새 리소스가 생성되었음을 클라이언트에 알리기 위해 응답 헤더에 201 Created `{{HTTP Status Code}}`를 반환했다." |
| **혼동 오답 피드백** | **오답 입력:** `HTTP Method`<br>**비교 피드백:** 서버의 요청 처리 결과 상태를 나타내는 3자리 숫자는 HTTP Status Code입니다. |

### 📌 Spring Security (Spring Security Framework)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Spring Security** |
| **공식 풀네임** | Spring Security Framework |
| **권장 발음** | 스프링 시큐리티 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprIN sI-kjU-rI-ti">Spring Security</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 서블릿 필터(Filter) 체인을 기반으로 인증(Authentication), 인가(Authorization), CSRF 방어, 세션 관리 등 엔터프라이즈 보안을 총괄하는 스프링 프레임워크 |
| **문맥 빈칸 예문** | "관리자 전용 URL 접근을 통제하고 사용자 로그인 인증 및 권한 검사를 체계적으로 구축하기 위해 `{{Spring Security}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `BCrypt`<br>**비교 피드백:** BCrypt는 비밀번호 해싱 알고리즘이며, 웹 애플리케이션 전체 보안 체계를 총괄하는 프레임워크는 Spring Security입니다. |

### 📌 Filter (Servlet Filter (javax.servlet.Filter))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Filter** |
| **공식 풀네임** | Servlet Filter (javax.servlet.Filter) |
| **권장 발음** | 서블릿 필터 (Filter) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="fIl-t@r">Filter</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 웹 애플리케이션의 서블릿 컨테이너(Tomcat) 레벨에서 DispatcherServlet에 요청이 도달하기 가장 앞단에서 인코딩이나 CORS, 보안을 검사하는 컴포넌트 |
| **문맥 빈칸 예문** | "UTF-8 문자 인코딩 설정과 Spring Security 인증 체인을 DispatcherServlet 진입 전 가장 먼저 처리하기 위해 서블릿 `{{Filter}}`를 등록했다." |
| **혼동 오답 피드백** | **오답 입력:** `Interceptor`<br>**비교 피드백:** Spring Context 진입 전 서블릿 컨테이너 가장 앞단에서 동작하는 것은 Filter입니다. |

### 📌 JWT (JSON Web Token)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **JWT** |
| **공식 풀네임** | JSON Web Token |
| **권장 발음** | 제이-더블유-티 (JSON 웹 토큰) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dZeI-dV-b@l-ju-ti">JWT</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Header, Payload, Signature로 구성되어 서버 세션 저장소 없이도 클라이언트가 보낸 토큰 자체의 암호화 서명만으로 유효성을 검증하는 무상태 인증 토큰 |
| **문맥 빈칸 예문** | "마이크로서비스 간에 중앙 세션 저장소 없이 무상태(Stateless)로 사용자 로그인 상태를 검증하기 위해 `Authorization: Bearer <{{JWT}}>`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Cookie`<br>**비교 피드백:** 클레임 정보와 디지털 서명을 자체 포함하여 서버 세션이 필요 없는 무상태 토큰은 JWT입니다. |

### 📌 Gradle (Gradle Build Automation Tool)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Gradle** |
| **공식 풀네임** | Gradle Build Automation Tool |
| **권장 발음** | 그레이들 (Gradle 빌드 도구) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="greI-d@l">Gradle</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Groovy 또는 Kotlin DSL 기반으로 `build.gradle` 파일에 의존성을 선언하고, 증분 빌드(Incremental Build)와 데몬 프로세스로 초고속 빌드를 지원하는 도구 |
| **문맥 빈칸 예문** | "스프링 부트 프로젝트의 라이브러리 의존성을 간결하게 관리하고 빌드 및 테스트를 자동화하기 위해 Maven 대신 `{{Gradle}}` (`./gradlew`)을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Maven`<br>**비교 피드백:** XML 대신 간결한 DSL 스크립트와 빠른 증분 빌드를 제공하는 현대 자바 표준 빌드 도구는 Gradle입니다. |

### 📌 Embedded Tomcat (Spring Boot Embedded Tomcat)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 7. Java, SpringBoot, REST API 구현 (30선) |
| **용어 원형** | **Embedded Tomcat** |
| **공식 풀네임** | Spring Boot Embedded Tomcat |
| **권장 발음** | 내장 톰캣 (임베디드 톰캣) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Em-bE-dId tAm-k{t">Embedded Tomcat</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 스프링 부트 애플리케이션 내부에 웹 서버(Tomcat)가 jar 파일의 일부로 내장되어 있어 외장 WAS 설치 없이 즉시 단독 기동되는 서블릿 컨테이너 |
| **문맥 빈칸 예문** | "별도로 외장 톰캣 서버를 구축하고 war를 배포하는 번거로움 없이 `java -jar`로 바로 8080 포트 웹 서버를 띄울 수 있는 것은 `{{Embedded Tomcat}}` 덕분이다." |
| **혼동 오답 피드백** | **오답 입력:** `Apache HTTP`<br>**비교 피드백:** 스프링 부트 jar 내부에 기본 탑재되어 단독 실행을 가능하게 해주는 서블릿 WAS는 Embedded Tomcat입니다. |

---

## 8. Agile 방법론 및 MSA 개발 (30선)

### 📌 Sprint (Scrum Sprint)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Sprint** |
| **공식 풀네임** | Scrum Sprint |
| **권장 발음** | 스프린트 (스크럼 반복 주기) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprInt">Sprint</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 애자일 스크럼 프레임워크에서 기획, 개발, 테스트를 거쳐 작동 가능한 산출물을 만들어내는 1~4주 단위의 반복 개발 주기 |
| **문맥 빈칸 예문** | "SKALA 팀 프로젝트에서 2주 단위의 {{Sprint}}를 설정하고, 매 주기마다 실제 구동 가능한 MVP 기능을 배포하기로 했다." |
| **혼동 오답 피드백** | **오답 입력:** `Waterfall`<br>**비교 피드백:** 1~4주 단위의 반복 개발 주기는 Sprint입니다. |

### 📌 kubectl (Kubernetes CLI (kubectl))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **kubectl** |
| **공식 풀네임** | Kubernetes CLI (kubectl) |
| **권장 발음** | 쿠브씨티엘 (쿠브컨트롤) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kjub-k@n-troUl">kubectl</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 쿠버네티스 클러스터의 상태를 확인하고 파드, 서비스, 배포를 터미널 CLI 환경에서 명령어로 제어하는 공식 도구 |
| **문맥 빈칸 예문** | "쿠버네티스 클러스터에서 현재 실행 중인 파드 목록을 조회하기 위해 CLI 터미널에서 `{{kubectl}} get pods` 명령어를 입력했다." |
| **혼동 오답 피드백** | **오답 입력:** `docker`<br>**비교 피드백:** 쿠버네티스 분산 클러스터를 제어하는 도구는 kubectl입니다. |

### 📌 Pod (Kubernetes Pod)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Pod** |
| **공식 풀네임** | Kubernetes Pod |
| **권장 발음** | 파드 (쿠버네티스 최소 배포 단위) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pAd">Pod</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 쿠버네티스에서 생성하고 관리할 수 있는 가장 작은 배포 단위로, 하나 이상의 도커 컨테이너와 네트워크를 공유하는 묶음 |
| **문맥 빈칸 예문** | "쿠버네티스 환경에서 스프링 부트 애플리케이션 컨테이너는 가장 작은 스케줄링 배포 단위인 {{Pod}} 형태로 노드 위에 기동된다." |
| **혼동 오답 피드백** | **오답 입력:** `Node`<br>**비교 피드백:** 쿠버네티스의 가장 작은 컨테이너 배포 객체는 Pod입니다. |

### 📌 Microservices (MSA) (Microservices Architecture)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Microservices (MSA)** |
| **공식 풀네임** | Microservices Architecture |
| **권장 발음** | 마이크로서비스 아키텍처 (MSA) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="maI-kroU-s3:r-vI-sIz">Microservices</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 단일 거대 시스템 대신, 독립적으로 배포 및 확장이 가능한 작은 서비스 단위들로 분할하여 API로 통신하는 아키텍처 |
| **문맥 빈칸 예문** | "회원 서비스와 주문 서비스의 장애 격리 및 독립적인 무중단 배포를 위해 거대 단일 앱을 `{{Microservices (MSA)}}` 구조로 전면 개편했다." |
| **혼동 오답 피드백** | **오답 입력:** `Monolithic`<br>**비교 피드백:** 작게 분할해 독립 운영하는 분산 아키텍처는 Microservices(MSA)입니다. |

### 📌 Product Backlog (Scrum Product Backlog)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Product Backlog** |
| **공식 풀네임** | Scrum Product Backlog |
| **권장 발음** | 프로덕트 백로그 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="prA-dVkt b{k-lOg">Product Backlog</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 제품에 필요한 모든 기능, 개선점, 과제를 우선순위에 따라 정렬해 놓은 제품 책임자(PO)가 관리하는 마스터 요구사항 목록 |
| **문맥 빈칸 예문** | "새로운 결제 기능 요구사항을 제품 전체 우선순위 목록인 `{{Product Backlog}}`에 등록하고 다음 스프린트 회의에서 다루기로 했다." |
| **혼동 오답 피드백** | **오답 입력:** `Sprint Backlog`<br>**비교 피드백:** 제품 전체 요구사항 마스터 목록은 Product Backlog입니다. |

### 📌 API Gateway (API Gateway (Spring Cloud Gateway))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **API Gateway** |
| **공식 풀네임** | API Gateway (Spring Cloud Gateway) |
| **권장 발음** | 에이피아이 게이트웨이 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="eI-pi-aI geIt-weI">API Gateway</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 클라이언트의 모든 요청을 단일 진입점으로 받아 인증/인가, 라우팅, 로드밸런싱을 일괄 처리하고 마이크로서비스로 분기해 주는 서버 |
| **문맥 빈칸 예문** | "클라이언트가 각 마이크로서비스 주소를 일일이 알 필요 없이 단일 엔드포인트로 접근하도록 앞단에 `{{API Gateway}}`를 배치했다." |
| **혼동 오답 피드백** | **오답 입력:** `Load Balancer`<br>**비교 피드백:** 인증·라우팅·변환 등 API 레벨의 관문 역할을 수행하는 것은 API Gateway입니다. |

### 📌 Circuit Breaker (Circuit Breaker Pattern)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Circuit Breaker** |
| **공식 풀네임** | Circuit Breaker Pattern |
| **권장 발음** | 서킷 브레이커 (차단기 패턴) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="s3:r-kIt breI-k@r">Circuit Breaker</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 외부 마이크로서비스 호출 실패가 반복될 때 호출을 즉시 차단(Open)하고 Fallback을 반환하여 장애 전파를 막는 패턴 |
| **문맥 빈칸 예문** | "결제 PG사 서버 장애로 인해 주문 서버 전체가 먹통이 되는 연쇄 장애를 막기 위해 Resilience4j `{{Circuit Breaker}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Service Discovery`<br>**비교 피드백:** 연쇄 장애 전파를 차단하는 안전 패턴은 Circuit Breaker입니다. |

### 📌 Docker Compose (Docker Compose)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Docker Compose** |
| **공식 풀네임** | Docker Compose |
| **권장 발음** | 도커 컴포즈 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dA-k@r k@m-poUz">Docker Compose</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `docker-compose.yml` 파일 하나로 여러 개의 컨테이너(웹 앱, MySQL, Redis 등)를 단 한 번의 명령어로 일괄 정의하고 동시 실행하는 도구 |
| **문맥 빈칸 예문** | "로컬 개발 환경에서 스프링 부트 서버, MySQL DB, Redis 캐시를 명령어 한 줄로 동시 기동하기 위해 `{{Docker Compose}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Dockerfile`<br>**비교 피드백:** 여러 컨테이너를 한 번에 오케스트레이션 실행하는 도구는 Docker Compose입니다. |

### 📌 Kafka (Apache Kafka)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Kafka** |
| **공식 풀네임** | Apache Kafka |
| **권장 발음** | 카프카 (분산 메시지 브로커) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kAf-k@">Kafka</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 대용량 실시간 데이터 스트림과 이벤트를 초당 수백만 건씩 높은 처리량과 영속성으로 발행(Pub) 및 구독(Sub)하는 분산 메시지 브로커 |
| **문맥 빈칸 예문** | "주문 완료 이벤트를 결제, 배송, 알림 서비스가 비동기로 수신하여 처리할 수 있도록 분산 메시지 큐인 `{{Kafka}}`를 도입했다." |
| **혼동 오답 피드백** | **오답 입력:** `Redis`<br>**비교 피드백:** 대용량 분산 이벤트 스트리밍에 특화된 고성능 플랫폼은 Kafka입니다. |

### 📌 Service Discovery (Service Discovery (Eureka))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Service Discovery** |
| **공식 풀네임** | Service Discovery (Eureka) |
| **권장 발음** | 서비스 디스커버리 (유레카) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="s3:r-vIs dIs-kV-v@-ri">Service Discovery</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 클라우드 환경에서 수시로 오토스케일링되며 IP/포트가 바뀌는 마이크로서비스들의 위치를 동적으로 등록하고 찾아주는 서비스 |
| **문맥 빈칸 예문** | "주문 서비스가 회원 서비스의 동적 IP 주소를 하드코딩하지 않고 서비스 이름(`USER-SERVICE`)으로 자동 찾도록 `{{Service Discovery}}`를 구성했다." |
| **혼동 오답 피드백** | **오답 입력:** `API Gateway`<br>**비교 피드백:** 백엔드 마이크로서비스들의 동적 위치를 등록하고 탐색하는 시스템은 Service Discovery입니다. |

### 📌 CI/CD (Continuous Integration and Deployment)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **CI/CD** |
| **공식 풀네임** | Continuous Integration and Deployment |
| **권장 발음** | 씨아이 / 씨디 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="si-aI si-di">CI CD</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 코드 커밋 시 자동으로 빌드/테스트를 수행하고(CI), 검증된 코드를 운영 서버에 자동으로 무중단 배포(CD)하는 자동화 파이프라인 |
| **문맥 빈칸 예문** | "GitHub에 PR이 병합되면 GitHub Actions가 자동으로 테스트를 돌리고 AWS EKS 클러스터에 배포하도록 `{{CI/CD}}` 파이프라인을 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `DevOps`<br>**비교 피드백:** 빌드·테스트·배포의 자동화 기술 파이프라인은 CI/CD입니다. |

### 📌 Saga Pattern (Saga Pattern)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Saga Pattern** |
| **공식 풀네임** | Saga Pattern |
| **권장 발음** | 사가 패턴 (분산 트랜잭션) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sA-g@ p{-t@rn">Saga Pattern</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | MSA 환경에서 여러 독립 DB 간의 트랜잭션을 위해 각 서비스의 로컬 트랜잭션을 실행하고 실패 시 보상 트랜잭션으로 롤백하는 패턴 |
| **문맥 빈칸 예문** | "회원 DB와 주문 DB가 분리된 환경에서 결제 실패 시 주문 취소 보상 트랜잭션을 실행하여 데이터 일관성을 맞추기 위해 `{{Saga Pattern}}`을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `2PC`<br>**비교 피드백:** 보상 트랜잭션 메시지로 비동기 최종 일관성을 맞추는 현대 MSA 기법은 Saga Pattern입니다. |

### 📌 Sprint Backlog (Scrum Sprint Backlog)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Sprint Backlog** |
| **공식 풀네임** | Scrum Sprint Backlog |
| **권장 발음** | 스프린트 백로그 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprInt b{k-lOg">Sprint Backlog</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 프로덕트 백로그에서 선별되어 이번 단일 스프린트 기간(1~2주) 내에 개발팀이 완료하기로 확정한 구체적인 작업 목록 |
| **문맥 빈칸 예문** | "이번 2주 차 스프린트 동안 구현할 '소셜 로그인'과 '장바구니 API' 작업 카드들을 `{{Sprint Backlog}}`에 등록하고 개발에 착수했다." |
| **혼동 오답 피드백** | **오답 입력:** `Product Backlog`<br>**비교 피드백:** 이번 스프린트 기간에 진행하기로 약속한 하위 태스크 목록은 Sprint Backlog입니다. |

### 📌 Daily Scrum (Daily Scrum (Stand-up Meeting))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Daily Scrum** |
| **공식 풀네임** | Daily Scrum (Stand-up Meeting) |
| **권장 발음** | 데일리 스크럼 (스탠드업 미팅) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="deI-li skrVm">Daily Scrum</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 매일 아침 개발팀원들이 모여 '어제 한 일', '오늘 할 일', '진행 중 겪는 장애물' 3가지를 15분 이내로 짧게 공유하는 스탠드업 회의 |
| **문맥 빈칸 예문** | "팀원 간의 업무 병목을 신속히 파악하고 협업을 조율하기 위해 매일 오전 9시 30분에 15분간 서서 진행하는 `{{Daily Scrum}}`을 진행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Sprint Review`<br>**비교 피드백:** 매일 아침 15분간 진행 상황과 장애물을 공유하는 일일 회의는 Daily Scrum입니다. |

### 📌 Sprint Review (Sprint Review Meeting)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Sprint Review** |
| **공식 풀네임** | Sprint Review Meeting |
| **권장 발음** | 스프린트 리뷰 (결과물 시연) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprInt rI-vju">Sprint Review</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 스프린트가 끝나는 시점에 프로덕트 오너(PO)와 이해관계자들을 모아놓고 이번 주기에 완성된 동작 가능한 소프트웨어 기능을 직접 시연하고 피드백을 받는 회의 |
| **문맥 빈칸 예문** | "2주간 완성한 어휘 퀴즈 기능을 PO와 강사진에게 시연하고 다음 요구사항 피드백을 수렴하기 위해 `{{Sprint Review}}`를 개최했다." |
| **혼동 오답 피드백** | **오답 입력:** `Sprint Retrospective`<br>**비교 피드백:** 완성된 제품 기능을 시연하고 피드백을 받는 회의는 Sprint Review입니다. |

### 📌 Sprint Retrospective (Sprint Retrospective (회고))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Sprint Retrospective** |
| **공식 풀네임** | Sprint Retrospective (회고) |
| **권장 발음** | 스프린트 회고 (Retrospective) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="sprInt rE-tr@-spEk-tIv">Sprint Retrospective</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 스프린트 종료 후 팀 내부적으로 협업 과정, 소통 방식, 개발 문화의 좋았던 점(Keep)과 아쉬운 점(Problem), 개선 액션(Try)을 도출하는 팀 회고 회의 |
| **문맥 빈칸 예문** | "다음 스프린트의 생산성과 팀워크를 높이기 위해 KPT 기법을 활용하여 이번 스프린트 프로세스를 반성하고 개선점을 찾는 `{{Sprint Retrospective}}`를 진행했다." |
| **혼동 오답 피드백** | **오답 입력:** `Sprint Review`<br>**비교 피드백:** 제품 기능 시연이 아닌, 팀의 협업 프로세스 자체를 되돌아보고 개선하는 회의는 Sprint Retrospective(회고)입니다. |

### 📌 Definition of Done (DoD) (Definition of Done (DoD))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Definition of Done (DoD)** |
| **공식 풀네임** | Definition of Done (DoD) |
| **권장 발음** | 완료의 정의 (DoD) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dE-fI-nI-S@n Vv dVn">Definition of Done</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 어떤 사용자 스토리나 태스크가 '완료'되었다고 공식 인정하기 위해 충족해야 하는 팀 공통의 엄격한 품질 체크리스트 (단위테스트 통과, 코드리뷰 완료 등) |
| **문맥 빈칸 예문** | "단순히 코드만 짠 것이 아니라 단위테스트 80% 통과와 PR 리뷰 승인까지 마쳐야 태스크를 완료 처리하기로 팀의 `{{Definition of Done (DoD)}}`을 합의했다." |
| **혼동 오답 피드백** | **오답 입력:** `User Story`<br>**비교 피드백:** 작업이 완전히 끝났음을 판정하는 팀 공통의 품질 기준 체크리스트는 Definition of Done (DoD)입니다. |

### 📌 User Story (Agile User Story)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **User Story** |
| **공식 풀네임** | Agile User Story |
| **권장 발음** | 사용자 스토리 (User Story) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ju-z@r stO-ri">User Story</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 기능 명세서를 기술적 관점이 아닌 사용자의 관점에서 '`<사용자>`로서 `<목적>`을 위해 `<어떤 기능>`을 원한다' 형태로 간결하게 작성한 요구사항 카드 |
| **문맥 빈칸 예문** | ""SKALA 교육생으로서 출퇴근길에 쾌속 복습을 하기 위해 모바일 스와이프 플래시카드 기능을 원한다" 형태로 `{{User Story}}`를 도출했다." |
| **혼동 오답 피드백** | **오답 입력:** `Use Case`<br>**비교 피드백:** 사용자 관점에서 가치 중심으로 간결하게 작성하는 애자일 요구사항 카드는 User Story입니다. |

### 📌 Story Point (Agile Story Point)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Story Point** |
| **공식 풀네임** | Agile Story Point |
| **권장 발음** | 스토리 포인트 (상대적 난이도) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="stO-ri pOInt">Story Point</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 태스크를 완료하는 데 걸리는 절대적 시간(시간/일) 대신, 피보나치 수열(1, 2, 3, 5, 8)을 사용하여 작업의 상대적 난이도와 복잡도를 추정하는 단위 |
| **문맥 빈칸 예문** | "플래닝 포커 게임을 통해 로그인 기능은 3점, 결제 시스템 연동은 8점의 `{{Story Point}}`를 부여하여 작업량을 산정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Man-Hour`<br>**비교 피드백:** 절대적 시간이 아닌 상대적 복잡도를 추정하는 애자일 산정 단위는 Story Point입니다. |

### 📌 Burn-down Chart (Scrum Burn-down Chart)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Burn-down Chart** |
| **공식 풀네임** | Scrum Burn-down Chart |
| **권장 발음** | 번다운 차트 (작업 소진 그래프) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="b3:rn daUn tSA:rt">Burn-down Chart</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 스프린트 진행 일자별로 남아있는 총 스토리 포인트(작업량)가 마감일을 향해 0으로 줄어드는 추이를 시각화하여 일정 지연을 조기 감지하는 그래프 |
| **문맥 빈칸 예문** | "스프린트 마감 3일을 앞두고 잔여 작업량이 이상선보다 완만하게 줄어드는 `{{Burn-down Chart}}`를 보고 스코프 조율을 결정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Kanban`<br>**비교 피드백:** 남은 작업량의 소진 추세를 선 그래프로 보여주는 시각화 도구는 Burn-down Chart입니다. |

### 📌 Kanban (Kanban Board)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Kanban** |
| **공식 풀네임** | Kanban Board |
| **권장 발음** | 칸반 (Kanban 보드) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kAn-bAn">Kanban</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | To Do(할 일), In Progress(진행 중), Done(완료)의 단계별 열(Column)을 통해 팀 전체의 작업 흐름을 한눈에 시각화하고 관리하는 도구 |
| **문맥 빈칸 예문** | "팀원들이 현재 어떤 기능을 개발 중인지 실시간으로 파악하고 병목을 없애기 위해 Jira의 `{{Kanban}}` 보드를 적극 활용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Scrum`<br>**비교 피드백:** 작업 상태를 카드 형태로 시각화하여 흐름을 관리하는 도구는 Kanban입니다. |

### 📌 WIP Limit (Work In Progress Limit)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **WIP Limit** |
| **공식 풀네임** | Work In Progress Limit |
| **권장 발음** | 뷥 리밋 (진행 중 작업 제한) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wIp lI-mIt">WIP Limit</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 칸반 보드에서 'In Progress' 열에 동시에 머물 수 있는 최대 작업 카드 개수를 제한하여, 멀티태스킹을 줄이고 작업 완료(Finish) 속도를 극대화하는 규칙 |
| **문맥 빈칸 예문** | "동시에 너무 많은 일을 벌여 마감이 지연되는 것을 막기 위해 개발자 1인당 진행 중 작업은 최대 2개로 제한하는 `{{WIP Limit}}` 규칙을 세웠다." |
| **혼동 오답 피드백** | **오답 입력:** `Velocity`<br>**비교 피드백:** 작업 흐름의 정체를 막기 위해 진행 중 태스크의 최대치를 강제하는 규칙은 WIP Limit입니다. |

### 📌 Monolithic (Monolithic Architecture)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Monolithic** |
| **공식 풀네임** | Monolithic Architecture |
| **권장 발음** | 모놀리식 아키텍처 (단일 구조) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="mA-n@-lI-TIk">Monolithic</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | UI, 비즈니스 로직, 데이터베이스 접근 등 시스템의 모든 기능이 하나의 거대한 단일 코드베이스와 단일 배포 파일로 묶여 있는 전통적 아키텍처 |
| **문맥 빈칸 예문** | "초기 스타트업 단계에서는 개발 속도가 빠르고 배포가 단순한 `{{Monolithic}}` 구조로 빠르게 MVP를 출시했다." |
| **혼동 오답 피드백** | **오답 입력:** `Microservices`<br>**비교 피드백:** 모든 기능이 하나의 거대한 프로젝트로 묶여 있는 단일 구조는 Monolithic입니다. |

### 📌 Service Mesh (Istio) (Service Mesh Architecture (Istio))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Service Mesh (Istio)** |
| **공식 풀네임** | Service Mesh Architecture (Istio) |
| **권장 발음** | 서비스 메시 (이스티오) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="s3:r-vIs mES Is-ti-oU">Service Mesh</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 마이크로서비스 간의 통신 경로에 Sidecar 프록시(Envoy)를 주입하여 서비스 간 통신 암호화(mTLS), 트래픽 라우팅, 모니터링을 인프라 레벨에서 일괄 제어하는 기술 |
| **문맥 빈칸 예문** | "애플리케이션 코드를 고치지 않고도 마이크로서비스 간 통신 보안과 카나리 트래픽 분할을 구현하기 위해 `{{Service Mesh (Istio)}}`를 클러스터에 배포했다." |
| **혼동 오답 피드백** | **오답 입력:** `API Gateway`<br>**비교 피드백:** 외부 관문이 아니라 내부 마이크로서비스 간(East-West)의 통신과 보안을 프록시로 제어하는 계층은 Service Mesh입니다. |

### 📌 Event-Driven Architecture (Event-Driven Architecture (EDA))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Event-Driven Architecture** |
| **공식 풀네임** | Event-Driven Architecture (EDA) |
| **권장 발음** | 이벤트 기반 아키텍처 (EDA) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="I-vEnt drI-v@n">Event-Driven</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 서비스들이 직접 REST API로 동기 호출하지 않고, 상태 변화(이벤트)를 메시지 큐에 발행(Publish)하면 관심 있는 서비스들이 비동기로 구독(Subscribe)하는 아키텍처 |
| **문맥 빈칸 예문** | "결제 서비스가 다운되어도 주문 접수는 중단되지 않도록 서비스 간 결합도를 완전히 분리하는 `{{Event-Driven Architecture}}`를 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `Monolithic`<br>**비교 피드백:** 이벤트를 비동기 발행/구독하여 결합도를 극단적으로 낮추는 구조는 Event-Driven Architecture입니다. |

### 📌 CQRS (Command Query Responsibility Segregation)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **CQRS** |
| **공식 풀네임** | Command Query Responsibility Segregation |
| **권장 발음** | 씨-큐-알-에스 (명령 조회 분리) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="si-kju-A:r-Es">CQRS</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 상태를 변경하는 명령(Command: 쓰기/수정) 모델과 상태를 읽어오는 조회(Query: 읽기) 모델의 책임을 완전히 분리하여 각각 최적의 DB로 독립 운영하는 패턴 |
| **문맥 빈칸 예문** | "대규모 조회 트래픽을 처리하기 위해 쓰기용 RDBMS와 초고속 읽기용 Elasticsearch/Redis를 분리 운영하는 `{{CQRS}}` 패턴을 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `CRUD`<br>**비교 피드백:** 쓰기 작업(Command)과 읽기 작업(Query)의 데이터 모델을 완전히 격리 분리하는 아키텍처 패턴은 CQRS입니다. |

### 📌 12-Factor App (The Twelve-Factor App Methodology)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **12-Factor App** |
| **공식 풀네임** | The Twelve-Factor App Methodology |
| **권장 발음** | 12-팩터 앱 (클라우드 원칙) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="twElv f{k-t@r">12-Factor App</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 클라우드 플랫폼(쿠버네티스 등)에서 확장성 높고 이식성이 뛰어난 마이크로서비스 웹 앱을 개발하기 위한 12가지 핵심 설계 원칙 (설정 분리, 무상태 프로세스 등) |
| **문맥 빈칸 예문** | "환경설정을 소스에 하드코딩하지 않고 환경변수로 주입받는 등 클라우드 네이티브 표준을 준수하기 위해 `{{12-Factor App}}` 가이드라인을 따랐다." |
| **혼동 오답 피드백** | **오답 입력:** `SOLID`<br>**비교 피드백:** 객체지향 설계 원칙은 SOLID이고, 클라우드 네이티브 SaaS 애플리케이션 구축 12대 원칙은 12-Factor App입니다. |

### 📌 Dockerfile (Docker Image Build Recipe (Dockerfile))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Dockerfile** |
| **공식 풀네임** | Docker Image Build Recipe (Dockerfile) |
| **권장 발음** | 도커파일 (Dockerfile) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dA-k@r-faIl">Dockerfile</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 베이스 OS 이미지 지정, 의존성 패키지 설치, 소스코드 복사, 기동 명령어(CMD) 등 도커 컨테이너 이미지를 빌드하기 위한 단계별 텍스트 스크립트 파일 |
| **문맥 빈칸 예문** | "자바 17 환경과 스프링 부트 jar 파일을 포함하는 경량 리눅스 컨테이너 이미지를 빌드하기 위해 프로젝트 루트에 `{{Dockerfile}}`을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Docker Compose`<br>**비교 피드백:** 단일 이미지를 빌드하기 위한 스크립트 파일은 Dockerfile이며, 여러 컨테이너를 동시 실행하는 설정은 Docker Compose입니다. |

### 📌 Kubernetes Deployment (Kubernetes Deployment Controller)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Kubernetes Deployment** |
| **공식 풀네임** | Kubernetes Deployment Controller |
| **권장 발음** | 쿠버네티스 디플로이먼트 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dI-plOI-m@nt">Deployment</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 쿠버네티스에서 지정된 개수의 파드(Pod) 복제본을 유지하고, 신버전 배포 시 중단 없는 롤링 업데이트(Rolling Update)와 자동 롤백을 관리하는 핵심 워크로드 객체 |
| **문맥 빈칸 예문** | "스프링 부트 파드를 3개 상시 유지하고 신규 버전으로 무중단 롤링 배포를 수행하기 위해 `{{Kubernetes Deployment}}` 매니페스트(YAML)를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pod`<br>**비교 피드백:** 개별 파드를 직접 관리하지 않고 파드의 복제본과 무중단 배포를 총괄 관리하는 쿠버네티스 컨트롤러는 Deployment입니다. |

### 📌 Blue-Green Deployment (Blue-Green Zero Downtime Deployment)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 8. Agile 방법론 및 MSA 개발 (30선) |
| **용어 원형** | **Blue-Green Deployment** |
| **공식 풀네임** | Blue-Green Zero Downtime Deployment |
| **권장 발음** | 블루-그린 배포 (무중단 배포) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="blu grin dI-plOI-m@nt">Blue-Green</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 현재 운영 중인 구버전 환경(Blue)과 똑같은 신버전 환경(Green)을 완전히 새롭게 구축한 뒤, 로드밸런서의 라우팅 스위칭만으로 0초 만에 무중단 전환하는 배포 기법 |
| **문맥 빈칸 예문** | "사용자 서비스 중단 없이 배포하고 장애 발생 시 라우터를 즉시 구버전으로 되돌리기 위해 `{{Blue-Green Deployment}}` 무중단 배포 전략을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Rolling Update`<br>**비교 피드백:** 인스턴스를 하나씩 점진 교체하는 것은 Rolling Update이며, 구버전과 신버전 환경 전체를 스위칭하는 방식은 Blue-Green Deployment입니다. |

---

## 9. Frontend Framework Vue.js (30선)

### 📌 v-model (Vue.js v-model Directive)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-model** |
| **공식 풀네임** | Vue.js v-model Directive |
| **권장 발음** | 브이-모델 (양방향 바인딩) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi mA-d@l">v-model</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 사용자가 입력한 `<input>`의 폼 값과 Vue 컴포넌트의 자바스크립트 반응형 변수를 실시간으로 동기화하는 양방향 바인딩 디렉티브 |
| **문맥 빈칸 예문** | "검색창 input 태그의 입력값과 `searchKeyword` 반응형 변수를 실시간으로 동기화하기 위해 `{{v-model}}="searchKeyword"`를 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `v-bind`<br>**비교 피드백:** 데이터에서 화면으로만 흐르는 단방향 바인딩은 v-bind이며, 양방향 동기화는 v-model입니다. |

### 📌 Reactivity (Vue 3 Reactivity System)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Reactivity** |
| **공식 풀네임** | Vue 3 Reactivity System |
| **권장 발음** | 반응형 시스템 (리액티비티) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ri-{k-tI-vI-ti">Reactivity</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 자바스크립트의 변수 값이 변경되면 이를 감지하여 해당 변수를 참조하고 있는 브라우저 화면의 DOM을 자동으로 갱신해 주는 Vue 핵심 엔진 |
| **문맥 빈칸 예문** | "Vue 3는 JavaScript ES6 `Proxy` 객체를 기반으로 데이터의 읽기/쓰기를 추적하여 화면을 자동 렌더링하는 `{{Reactivity}}` 시스템을 제공한다." |
| **혼동 오답 피드백** | **오답 입력:** `Virtual DOM`<br>**비교 피드백:** 데이터 변경을 감지하고 화면 갱신을 트리거하는 엔진은 Reactivity 시스템입니다. |

### 📌 computed (Vue.js computed property)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **computed** |
| **공식 풀네임** | Vue.js computed property |
| **권장 발음** | 컴퓨티드 (계산된 속성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="k@m-pju-tId">computed</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 반응형 의존성 데이터가 변경될 때만 재연산되고, 그렇지 않으면 이전 계산 결과를 캐싱하여 성능을 최적화하는 읽기 전용 속성 |
| **문맥 빈칸 예문** | "전체 상품 목록 중 품절되지 않은 상품만 필터링한 개수를 구할 때 불필요한 재연산을 막고 캐싱을 활용하기 위해 `{{computed}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `watch`<br>**비교 피드백:** 계산된 결과를 캐싱하여 템플릿에 반환하는 읽기 전용 속성은 computed입니다. |

### 📌 watch (Vue.js watch and watchEffect)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **watch** |
| **공식 풀네임** | Vue.js watch and watchEffect |
| **권장 발음** | 와치 (데이터 감시자) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wAtS">watch</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 특정 반응형 데이터의 변경을 감시하고 있다가, 값이 바뀌는 즉시 비동기 API 호출이나 로컬 스토리지 저장 등의 사이드 이펙트를 수행하는 함수 |
| **문맥 빈칸 예문** | "사용자가 선택한 카테고리 ID가 변경될 때마다 서버에서 새로운 상품 목록을 비동기로 다시 불러오기 위해 `{{watch}}(selectedId, fetchProducts)`를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `computed`<br>**비교 피드백:** 값 변경 시 API 호출 등의 사이드 이펙트를 실행하는 것은 watch입니다. |

### 📌 Pinia (Pinia State Management)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Pinia** |
| **공식 풀네임** | Pinia State Management |
| **권장 발음** | 피니아 (Vue 3 공식 상태 관리) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pi-ni-@">Pinia</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Vue 3 공식 전역 상태 관리 라이브러리로, Vuex보다 가볍고 완벽한 TypeScript 지원과 직관적인 Store(State, Getters, Actions) 구조를 제공 |
| **문맥 빈칸 예문** | "로그인한 사용자의 프로필과 장바구니 데이터를 모든 화면 컴포넌트에서 공통으로 공유하고 관리하기 위해 Vue 3 공식 라이브러리인 `{{Pinia}}`를 도입했다." |
| **혼동 오답 피드백** | **오답 입력:** `Vuex`<br>**비교 피드백:** Vue 3의 공식 권장 표준 상태 관리 라이브러리는 Pinia입니다. |

### 📌 SFC (Single File Component (.vue))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **SFC** |
| **공식 풀네임** | Single File Component (.vue) |
| **권장 발음** | 싱글 파일 컴포넌트 (SFC) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Es-Ef-si">SFC</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 하나의 `.vue` 파일 안에 `<template>`(HTML), `<script>`(JS), `<style>`(CSS)의 3요소를 모두 캡슐화하여 개발하는 Vue 고유의 컴포넌트 포맷 |
| **문맥 빈칸 예문** | "화면 UI 구조, 비즈니스 로직, 캡슐화된 스타일을 파일 하나로 깔끔하게 모듈화하기 위해 Vue의 `{{SFC}}`(.vue) 구조를 사용한다." |
| **혼동 오답 피드백** | **오답 입력:** `JSX`<br>**비교 피드백:** template/script/style을 하나의 .vue 파일로 묶는 Vue 컴포넌트 포맷은 SFC입니다. |

### 📌 Props / Emits (Props Down, Events Up Communication)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Props / Emits** |
| **공식 풀네임** | Props Down, Events Up Communication |
| **권장 발음** | 프롭스 / 에밋 (컴포넌트 통신) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="prAps I-mIts">Props Emits</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 부모 컴포넌트가 자식에게 데이터를 전달할 때는 단방향 Props로 내리고, 자식이 부모에게 상태 변경을 알릴 때는 Event(Emits)를 올려보내는 원칙 |
| **문맥 빈칸 예문** | "단방향 데이터 흐름을 준수하기 위해 부모에서 자식으로는 `defineProps`로 데이터를 넘기고, 자식에서 부모로는 `defineEmits`의 `{{Props / Emits}}` 패턴을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Provide / Inject`<br>**비교 피드백:** 직계 부모-자식 컴포넌트 간의 표준 단방향 통신 원칙은 Props / Emits입니다. |

### 📌 Vue Router (Vue Router (SPA Routing))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Vue Router** |
| **공식 풀네임** | Vue Router (SPA Routing) |
| **권장 발음** | 뷰 라우터 (Vue Router) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vju ru-t@r">Vue Router</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Single Page Application(SPA) 환경에서 브라우저를 새로고침하지 않고 URL 경로에 따라 해당하는 뷰 컴포넌트를 매끄럽게 교체 렌더링하는 공식 라우터 |
| **문맥 빈칸 예문** | "페이지 깜빡임 없이 `/catalog`, `/learn`, `/stats` 등 URL 주소 변경에 맞춰 컴포넌트를 즉시 전환하기 위해 `{{Vue Router}}`를 설정했다." |
| **혼동 오답 피드백** | **오답 입력:** `Pinia`<br>**비교 피드백:** URL 주소에 맞춰 화면 뷰를 전환 렌더링하는 공식 라이브러리는 Vue Router입니다. |

### 📌 Virtual DOM (Virtual Document Object Model)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Virtual DOM** |
| **공식 풀네임** | Virtual Document Object Model |
| **권장 발음** | 가상 돔 (Virtual DOM) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="v3:r-tSu-@l dAm">Virtual DOM</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 실제 브라우저 DOM 조작의 높은 비용을 줄이기 위해, 메모리에 가벼운 자바스크립트 가상 트리를 두고 변경 전후를 비교(Diffing)해 바뀐 부분만 실제 돔에 패치하는 기술 |
| **문맥 빈칸 예문** | "화면의 수많은 요소 중 실제로 바뀐 텍스트 노드 하나만 최소한의 비용으로 렌더링하기 위해 Vue 내부의 `{{Virtual DOM}}` 엔진이 동작한다." |
| **혼동 오답 피드백** | **오답 입력:** `Shadow DOM`<br>**비교 피드백:** 메모리 상에서 가상 객체 트리로 Diffing 연산을 수행하는 것은 Virtual DOM입니다. |

### 📌 v-if vs v-show (v-if and v-show Directives)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-if vs v-show** |
| **공식 풀네임** | v-if and v-show Directives |
| **권장 발음** | 브이-이프 vs 브이-쇼 |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi If vi SoU">v-if v-show</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `v-if`는 조건이 거짓일 때 DOM 요소를 아예 생성하지 않고 삭제하며, `v-show`는 DOM에 렌더링해 둔 채 CSS `display: none`으로만 숨기는 디렉티브 |
| **문맥 빈칸 예문** | "모달 창처럼 빈번하게 켜고 끄는 UI는 렌더링 전환 비용이 적은 `v-show`를, 권한처럼 런타임에 거의 안 바뀌는 UI는 `{{v-if vs v-show}}`의 `v-if`를 적용한다." |
| **혼동 오답 피드백** | **오답 입력:** `v-bind vs v-model`<br>**비교 피드백:** 조건부 렌더링 및 노출을 제어하는 디렉티브는 v-if vs v-show입니다. |

### 📌 Lifecycle Hooks (Vue.js Lifecycle Hooks)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Lifecycle Hooks** |
| **공식 풀네임** | Vue.js Lifecycle Hooks |
| **권장 발음** | 라이프사이클 훅 (생명주기 훅) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="laIf-saI-k@l hUks">Lifecycle Hooks</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 컴포넌트가 생성(Create), 화면에 부착(Mounted), 갱신(Updated), 소멸(Unmounted)되는 각 생명주기 단계마다 특정 로직을 실행할 수 있는 함수들 |
| **문맥 빈칸 예문** | "컴포넌트가 화면에 완전히 마운트된 직후 백엔드 API로부터 초기 데이터를 불러오기 위해 `onMounted` `{{Lifecycle Hooks}}`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Directives`<br>**비교 피드백:** 컴포넌트의 생명주기 특정 시점에 실행되는 콜백 함수들은 Lifecycle Hooks입니다. |

### 📌 Composable (Vue 3 Custom Composables (useXxx))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Composable** |
| **공식 풀네임** | Vue 3 Custom Composables (useXxx) |
| **권장 발음** | 컴포저블 (Composition API 커스텀 함수) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="k@m-poU-z@-b@l">Composable</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | Vue 3 Composition API를 활용해 상태(State)와 비즈니스 로직을 `useXxx` 형태의 독립된 함수로 묶어 여러 컴포넌트에서 깔끔하게 재사용할 수 있게 만든 모듈 |
| **문맥 빈칸 예문** | "마우스 좌표 추적이나 페이지네이션 로직을 여러 화면에서 재사용하기 위해 `usePagination.js` 형태의 커스텀 `{{Composable}}` 함수를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `Mixin`<br>**비교 피드백:** Vue 3에서 상태를 가진 비즈니스 로직을 함수 단위로 재사용하는 모던 표준은 Composable입니다. |

### 📌 SPA (Single Page Application)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **SPA** |
| **공식 풀네임** | Single Page Application |
| **권장 발음** | 에스-피-에이 (단일 페이지 애플리케이션) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="Es-pi-eI">SPA</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 서버로부터 매번 새로운 HTML 페이지를 통째로 다시 받아오는 대신, 단 하나의 HTML을 로드한 후 필요한 데이터만 자바스크립트로 비동기 갱신하는 웹 앱 |
| **문맥 빈칸 예문** | "깜빡임 없는 부드러운 화면 전환과 모바일 앱 같은 사용자 경험(UX)을 제공하기 위해 Vue.js 기반의 `{{SPA}}` 아키텍처를 구축했다." |
| **혼동 오답 피드백** | **오답 입력:** `MPA`<br>**비교 피드백:** 새로고침 없이 단일 HTML 위에서 자바스크립트로 화면을 동적 렌더링하는 웹 애플리케이션 구조는 SPA입니다. |

### 📌 v-bind (Vue.js v-bind Directive (:))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-bind** |
| **공식 풀네임** | Vue.js v-bind Directive (:) |
| **권장 발음** | 브이-바인드 (: 속성 바인딩) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi baInd">v-bind</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | HTML 태그의 속성(class, style, href, disabled 등)이나 컴포넌트의 props에 자바스크립트 반응형 변수를 단방향으로 동적 연결하는 디렉티브 |
| **문맥 빈칸 예문** | "버튼의 비활성화 여부를 `isLoading` 변수 상태에 따라 동적으로 제어하기 위해 `{{v-bind}}:disabled="isLoading"` (약어 `:disabled`)을 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `v-model`<br>**비교 피드백:** 데이터에서 HTML 속성으로 단방향 전달하는 디렉티브는 v-bind (:)입니다. |

### 📌 v-on (Vue.js v-on Directive (@))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-on** |
| **공식 풀네임** | Vue.js v-on Directive (@) |
| **권장 발음** | 브이-온 (@ 이벤트 리스너) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi An">v-on</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 클릭, 마우스 이동, 키보드 입력 등 브라우저 DOM 이벤트를 감지하여 Vue 컴포넌트의 자바스크립트 메서드를 트리거하는 디렉티브 (약어 `@`) |
| **문맥 빈칸 예문** | "사용자가 제출 버튼을 클릭했을 때 `handleSubmit` 함수를 실행하기 위해 `{{v-on}}:click="handleSubmit"` (약어 `@click`)을 바인딩했다." |
| **혼동 오답 피드백** | **오답 입력:** `v-bind`<br>**비교 피드백:** DOM 이벤트를 수신하여 핸들러를 실행하는 디렉티브는 v-on (@)입니다. |

### 📌 v-for (Vue.js v-for Directive (:key))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-for** |
| **공식 풀네임** | Vue.js v-for Directive (:key) |
| **권장 발음** | 브이-포 (:key 반복 렌더링) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi fOr">v-for</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 배열이나 객체의 데이터 목록을 순회하면서 HTML 요소를 반복적으로 렌더링하는 디렉티브 (가상 돔 추적을 위해 고유 `:key` 바인딩 필수) |
| **문맥 빈칸 예문** | "단어 목록 배열 `words`를 화면에 카드 형태로 반복 출력하기 위해 `<div {{v-for}}="w in words" :key="w.wordId">` 구문을 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `v-if`<br>**비교 피드백:** 배열 데이터를 순회하며 여러 DOM 요소를 반복 출력하는 디렉티브는 v-for입니다. |

### 📌 v-slot (Vue.js v-slot Directive (#))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-slot** |
| **공식 풀네임** | Vue.js v-slot Directive (#) |
| **권장 발음** | 브이-슬롯 (# 슬롯 주입) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi slAt">v-slot</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 부모 컴포넌트가 자식 컴포넌트의 템플릿 내부 특정 위치(Header, Body, Footer 등)에 원하는 커스텀 HTML 마크업을 끼워 넣을 수 있게 해주는 문법 |
| **문맥 빈칸 예문** | "모달 컴포넌트의 제목과 본문 영역에 부모가 원하는 커스텀 UI를 전달하기 위해 `<template {{v-slot}}:header>` (약어 `#header`)를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Props`<br>**비교 피드백:** 데이터 값이 아닌 템플릿 마크업 조각 자체를 자식의 특정 구멍에 주입하는 문법은 v-slot (#)입니다. |

### 📌 v-html (Vue.js v-html Directive)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **v-html** |
| **공식 풀네임** | Vue.js v-html Directive |
| **권장 발음** | 브이-에이치티엠엘 (원시 HTML 출력) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vi eItS-ti-Em-El">v-html</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 자바스크립트 문자열에 포함된 `<span>`이나 `<mark>` 같은 HTML 태그를 일반 텍스트로 이스케이프하지 않고 실제 마크업으로 화면에 렌더링하는 디렉티브 |
| **문맥 빈칸 예문** | "예문 문장 중에서 검색어 키워드 부분에 형광펜 하이라이트 태그를 씌워 화면에 렌더링하기 위해 `{{v-html}}="highlightedText"`를 사용했다." |
| **혼동 오답 피드백** | **오답 입력:** `v-text`<br>**비교 피드백:** 태그를 이스케이프하지 않고 순수 HTML 마크업으로 렌더링하는 디렉티브는 v-html입니다. |

### 📌 Composition API (Vue 3 Composition API)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Composition API** |
| **공식 풀네임** | Vue 3 Composition API |
| **권장 발음** | 컴포지션 에이피아이 (Composition API) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="kAm-p@-zI-S@n eI-pi-aI">Composition API</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | Vue 2의 Options API(data, methods, computed 분리)와 달리, 하나의 기능에 관련된 상태와 로직을 자유롭게 한곳에 모아 모듈화할 수 있는 Vue 3 함수 기반 API |
| **문맥 빈칸 예문** | "학습 세션 타이머 기능과 채점 로직을 기능별로 응집도 높게 작성하고 재사용성을 극대화하기 위해 Vue 3 `{{Composition API}}`를 전면 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Options API`<br>**비교 피드백:** 기능별로 상태와 로직을 함수 단위로 응집시키는 Vue 3의 모던 API는 Composition API입니다. |

### 📌 <script setup> (Vue 3 <script setup> Syntax)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **<script setup>** |
| **공식 풀네임** | Vue 3 <script setup> Syntax |
| **권장 발음** | 스크립트 셋업 (<script setup>) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="skrIpt sE-tVp">script setup</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | Composition API를 사용할 때 번거로운 `setup()` 함수와 `return {}` 문을 생략하고, 최상위에 선언한 모든 변수와 함수가 템플릿에 자동 노출되는 Vue 3 표준 문법 |
| **문맥 빈칸 예문** | "보일러플레이트 코드를 최소화하고 컴포넌트 코드를 가장 간결하고 직관적으로 작성하기 위해 SFC 상단에 `{{<script setup>}}`을 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `setup()`<br>**비교 피드백:** return 문 없이 최상위 선언이 템플릿에 자동 바인딩되는 Vue 3의 가장 간결한 SFC 문법은 <script setup>입니다. |

### 📌 ref (Vue 3 ref() Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **ref** |
| **공식 풀네임** | Vue 3 ref() Function |
| **권장 발음** | 레프 (ref 반응형 원시값) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="rEf">ref</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 문자열, 숫자, 불리언 같은 원시 타입이나 객체를 감싸서 `.value` 속성을 통해 반응성을 부여하고 추적하는 Vue 3 핵심 함수 |
| **문맥 빈칸 예문** | "사용자가 텍스트 입력창에 타이핑하는 단일 문자열 상태를 반응형으로 관리하기 위해 `const input = {{ref}}("");`를 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `reactive`<br>**비교 피드백:** 원시값을 감싸 .value로 접근하는 반응형 생성 함수는 ref입니다. |

### 📌 reactive (Vue 3 reactive() Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **reactive** |
| **공식 풀네임** | Vue 3 reactive() Function |
| **권장 발음** | 리액티브 (reactive 객체 반응성) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="ri-{k-tIv">reactive</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 객체(Object)나 배열(Array) 자체를 JavaScript Proxy로 감싸서, `.value` 없이 프로퍼티에 직접 접근하여 깊은 반응성(Deep Reactivity)을 제공하는 함수 |
| **문맥 빈칸 예문** | "여러 개의 입력 폼 필드들을 하나의 묶음 객체로 반응형 관리하기 위해 `const form = {{reactive}}({ term: '', meaning: '' });`를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `ref`<br>**비교 피드백:** .value 없이 객체 자체를 Proxy로 감싸 깊은 반응성을 부여하는 함수는 reactive입니다. |

### 📌 watchEffect (Vue 3 watchEffect Function)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **watchEffect** |
| **공식 풀네임** | Vue 3 watchEffect Function |
| **권장 발음** | 와치이펙트 (자동 의존성 감시자) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="wAtS I-fEkt">watchEffect</phoneme></speak>` |
| **난이도** | `MEDIUM` |
| **비전공자 뜻풀이** | 감시할 대상을 명시하지 않아도 콜백 함수 내부에서 참조한 모든 반응형 변수를 자동으로 추적하여, 의존성이 바뀔 때마다 즉시 재실행되는 함수 |
| **문맥 빈칸 예문** | "선택된 과목 ID나 검색어가 바뀔 때마다 자동으로 필터링 연산을 즉각 재실행하기 위해 `{{watchEffect}}(() => filterWords())`를 등록했다." |
| **혼동 오답 피드백** | **오답 입력:** `watch`<br>**비교 피드백:** 의존 대상을 수동 지정하는 watch와 달리 콜백 내부의 반응형 변수를 자동 추적하여 즉시 실행하는 함수는 watchEffect입니다. |

### 📌 onMounted (Vue 3 onMounted Lifecycle Hook)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **onMounted** |
| **공식 풀네임** | Vue 3 onMounted Lifecycle Hook |
| **권장 발음** | 온마운티드 (마운트 완료 훅) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="An maUn-tId">onMounted</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 컴포넌트의 초기 DOM 렌더링이 브라우저 화면에 완전히 부착(Mount)된 직후에 단 한 번 실행되는 라이프사이클 훅 |
| **문맥 빈칸 예문** | "화면이 브라우저에 뜨자마자 로컬 스토리지에서 이전 학습 진도 데이터를 읽어와 복원하기 위해 `{{onMounted}}` 훅 내부에서 초기화 코드를 실행했다." |
| **혼동 오답 피드백** | **오답 입력:** `onUnmounted`<br>**비교 피드백:** 컴포넌트 DOM이 화면에 부착된 직후 실행되는 생명주기 훅은 onMounted입니다. |

### 📌 onUnmounted (Vue 3 onUnmounted Lifecycle Hook)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **onUnmounted** |
| **공식 풀네임** | Vue 3 onUnmounted Lifecycle Hook |
| **권장 발음** | 온언마운티드 (소멸 직전 훅) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="An Vn-maUn-tId">onUnmounted</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 컴포넌트가 화면에서 제거되어 파괴(Unmount)되기 직전에 실행되어, 메모리 누수를 막기 위해 타이머나 전역 이벤트 리스너를 정리하는 훅 |
| **문맥 빈칸 예문** | "학습 세션 화면을 벗어날 때 1초 타이머 `clearInterval()`과 윈도우 키보드 리스너를 안전하게 해제하기 위해 `{{onUnmounted}}`를 구현했다." |
| **혼동 오답 피드백** | **오답 입력:** `onMounted`<br>**비교 피드백:** 컴포넌트가 소멸될 때 리소스를 청소하고 정리하는 생명주기 훅은 onUnmounted입니다. |

### 📌 defineProps (Vue 3 defineProps Compiler Macro)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **defineProps** |
| **공식 풀네임** | Vue 3 defineProps Compiler Macro |
| **권장 발음** | 디파인 프롭스 (부모 전달값 선언) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dI-faIn prAps">defineProps</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `<script setup>` 내부에서 부모 컴포넌트로부터 전달받을 Props의 타입과 기본값, 필수 여부를 선언하는 컴파일러 매크로 |
| **문맥 빈칸 예문** | "부모가 넘겨준 단어 객체 `card`를 자식 컴포넌트에서 안전하게 전달받기 위해 `const props = {{defineProps}}({ card: Object });`를 선언했다." |
| **혼동 오답 피드백** | **오답 입력:** `defineEmits`<br>**비교 피드백:** 부모로부터 데이터를 수신하기 위해 Props를 선언하는 매크로는 defineProps입니다. |

### 📌 defineEmits (Vue 3 defineEmits Compiler Macro)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **defineEmits** |
| **공식 풀네임** | Vue 3 defineEmits Compiler Macro |
| **권장 발음** | 디파인 에밋 (자식 이벤트 선언) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="dI-faIn I-mIts">defineEmits</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `<script setup>` 내부에서 자식 컴포넌트가 부모 컴포넌트를 향해 발생(발행)시킬 수 있는 커스텀 이벤트 목록을 선언하는 컴파일러 매크로 |
| **문맥 빈칸 예문** | "스와이프 평가 완료 시 부모에게 채점 결과를 알리는 'rate' 이벤트를 선언하기 위해 `const emit = {{defineEmits}}(['rate']);`를 작성했다." |
| **혼동 오답 피드백** | **오답 입력:** `defineProps`<br>**비교 피드백:** 부모를 향해 이벤트를 발행할 수 있도록 선언하는 매크로는 defineEmits입니다. |

### 📌 Provide / Inject (Vue 3 Provide and Inject Pattern)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Provide / Inject** |
| **공식 풀네임** | Vue 3 Provide and Inject Pattern |
| **권장 발음** | 프로바이드 / 인젝트 (장거리 의존성 주입) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="pr@-vaId In-dZEkt">Provide Inject</phoneme></speak>` |
| **난이도** | `HARD` |
| **비전공자 뜻풀이** | 중간 컴포넌트들을 거쳐 props를 일일이 내리는 Props Drilling 없이, 최상위 조상 컴포넌트가 깊은 곳에 있는 자손에게 데이터를 직통으로 주입하는 패턴 |
| **문맥 빈칸 예문** | "앱 루트에서 설정한 테마나 전역 언어 설정을 5단계 아래의 깊은 하위 컴포넌트에서 직접 꺼내 쓰기 위해 `{{Provide / Inject}}`를 활용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Props`<br>**비교 피드백:** 중간 컴포넌트를 건너뛰고 깊은 자손에게 직접 데이터를 주입하는 패턴은 Provide / Inject입니다. |

### 📌 Scoped CSS (Vue Scoped CSS (<style scoped>))
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Scoped CSS** |
| **공식 풀네임** | Vue Scoped CSS (<style scoped>) |
| **권장 발음** | 스코프드 씨에스에스 (스타일 격리) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="skoUpt si-Es-Es">Scoped CSS</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | `<style scoped>`를 선언하면 Vue가 컴포넌트 내부 DOM 요소에 고유한 `data-v-xxxx` 속성을 부여하여 다른 컴포넌트의 스타일에 간섭받지 않게 격리하는 기능 |
| **문맥 빈칸 예문** | "카드 컴포넌트의 `.btn` 클래스 스타일이 다른 화면의 버튼 디자인을 오염시키지 않고 해당 파일 안에서만 동작하도록 `{{Scoped CSS}}`를 적용했다." |
| **혼동 오답 피드백** | **오답 입력:** `Global CSS`<br>**비교 피드백:** 컴포넌트 고유의 data 속성을 통해 스타일 충돌을 원천 방지하는 기능은 Scoped CSS (<style scoped>)입니다. |

### 📌 Vite (Vite Next-Gen Frontend Tooling)
| 필드명 | 데이터 상세 |
| :--- | :--- |
| **과목** | 9. Frontend Framework Vue.js (30선) |
| **용어 원형** | **Vite** |
| **공식 풀네임** | Vite Next-Gen Frontend Tooling |
| **권장 발음** | 비트 (Vite 차세대 빌드 도구) |
| **SSML 태그** | `<speak><phoneme alphabet="x-sampa" ph="vit">Vite</phoneme></speak>` |
| **난이도** | `EASY` |
| **비전공자 뜻풀이** | 개발 시 브라우저 네이티브 ES Modules(ESM)을 활용하여 번들링 없이 0.05초 만에 서버를 기동하고 초고속 HMR을 제공하는 차세대 프론트엔드 빌드 툴 |
| **문맥 빈칸 예문** | "기존 Webpack의 느린 빌드 속도에서 벗어나 수정 즉시 브라우저에 반영되는 초고속 개발 환경을 구축하기 위해 `{{Vite}}`를 개발 서버로 채택했다." |
| **혼동 오답 피드백** | **오답 입력:** `Webpack`<br>**비교 피드백:** 네이티브 ESM 기반으로 초고속 서버 구동과 HMR을 지원하는 차세대 빌드 도구는 Vite입니다. |

---
