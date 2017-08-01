function Graph1() {
  const g = [];

  const edge = (a, b) => g.push([a, b]);
	const from = x => g.filter(([a, _]) => a === x).map(([_, b]) => b);
	const to = x => g.filter(([_, b]) => b === x).map(([a, _]) => a);

  return {
	  edge,
	  from,
	  to,
  };

}

function Graph3() {
  const g = new Map();

  const edge = (a, b) => {
    if (!g.has(a)) {
      g.set(a, []);
    }

    if (!g.get(a).find(x => x === b)) {
      g.get(a).push(b);
    }
  };

	const from = x => g.get(x) || [];

  const to = x => {
    const tos = [];

    for (let value of g) {
      const [a, b] = value;

      if (b.find(v => v === x)) {
        tos.push(a);
      }
    }

    return tos;
  };

  return {
	  edge,
	  from,
	  to,
    id: () => g
  };

}

var g2 = Graph3();
g2.edge(1,2);
g2.edge(2,4);
g2.edge(2,8);
g2.edge(8,9);
g2.edge(9,13);
g2.edge(13, 1);

const _travel = start => (verticle, g) => {
  if (g.has(verticle)) {
    g.get(verticle).forEach(
      e => {
        if (e !== start) {
          console.log(e);
          _travel(start)(e, g);
        }
      }
    );
  }
};

const travel = (verticle, g) => _travel(verticle)(verticle, g);

const _findCycle3 = (g, a) => {
  if (!g.has(a)) {
    return false;
  };

  return true;
};

const edges3 = g => [...g.entries()].map(
  ([key, values]) => values.map(val => [key, val])
).reduce((a, b) => a.concat(b), []);

const isCyclic3 = g => {

};

function DAG3() {
}
