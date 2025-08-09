
# só conta as linhas do código Java

from pathlib import Path

root = Path()
linha = 0

for path in root.glob("**/*.java"):
    if path.is_file():
        with open(path, mode="r", encoding="utf-8") as file:
            linha += sum(1 for _ in file)

print(f"Total de linhas de código Java: {linha}")
