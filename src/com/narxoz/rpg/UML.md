<<interface>> HeroState
------------------------
+ getName(): String
+ modifyOutgoingDamage(int): int
+ modifyIncomingDamage(int): int
+ onTurnStart(Hero): void
+ onTurnEnd(Hero): void
+ canAct(): boolean

NormalState
------------------------
+ getName(): String
+ modifyOutgoingDamage(int): int
+ modifyIncomingDamage(int): int
+ onTurnStart(Hero): void
+ onTurnEnd(Hero): void
+ canAct(): boolean

PoisonedState
------------------------
+ turns: int
+ getName(): String
+ modifyOutgoingDamage(int): int
+ modifyIncomingDamage(int): int
+ onTurnStart(Hero): void
+ onTurnEnd(Hero): void
+ canAct(): boolean

StunnedState
------------------------
+ turns: int
+ getName(): String
+ modifyOutgoingDamage(int): int
+ modifyIncomingDamage(int): int
+ onTurnStart(Hero): void
+ onTurnEnd(Hero): void
+ canAct(): boolean

BerserkState
------------------------
+ getName(): String
+ modifyOutgoingDamage(int): int
+ modifyIncomingDamage(int): int
+ onTurnStart(Hero): void
+ onTurnEnd(Hero): void
+ canAct(): boolean

Hero
------------------------
- name: String
- hp: int
- maxHp: int
- attackPower: int
- defense: int
- state: HeroState 

------------------------
+ setState(HeroState): void
+ getState(): HeroState
+ attack(): int
+ takeDamage(int): void
+ heal(int): void
+ takeTurn(Monster): void

Hero ---------> HeroState
NormalState ---|
PoisonedState -|--> HeroState
StunnedState --|
BerserkState --|

<<abstract>> TowerFloor
----------------------------------
+ explore(List<Hero>): FloorResult  FINAL

# announce(): void
# setup(List<Hero>): void  ABSTRACT
# resolveChallenge(List<Hero>): FloorResult  ABSTRACT
# awardLoot(List<Hero>, FloorResult): void  ABSTRACT
# shouldAwardLoot(FloorResult): boolean
# cleanup(List<Hero>): void
# getFloorName(): String  ABSTRACT

CombatFloor
--------------------------
+ setup()
+ resolveChallenge()
+ awardLoot()
+ getFloorName()

TrapFloor
--------------------------
+ setup()
+ resolveChallenge()
+ awardLoot()
+ getFloorName()

RestFloor
--------------------------
+ announce()  override hook
+ setup()
+ resolveChallenge()
+ awardLoot()
+ shouldAwardLoot() override hook
+ cleanup()
+ getFloorName()

BossFloor
--------------------------
+ announce() override hook
+ setup()
+ resolveChallenge()
+ awardLoot()
+ getFloorName()

CombatFloor ----|
TrapFloor ------|--> TowerFloor
RestFloor ------|
BossFloor ------|

explore() FINAL
   ↓
announce()
setup()
resolveChallenge()
shouldAwardLoot()
awardLoot()
cleanup()