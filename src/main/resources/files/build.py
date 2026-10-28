import json, glob
tasks = [json.load(open(f, encoding="utf-8")) for f in sorted(glob.glob("tasks/*.json"))]
ids = [t["id"] for t in tasks]
assert len(ids) == len(set(ids)), "duplicate task id"
open("tasks.js", "w", encoding="utf-8").write("window.TASKS = " + json.dumps(tasks, ensure_ascii=False) + ";\n")
print(f"bundled {len(tasks)} tasks")
