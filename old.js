// supports only string keys
// lame

// function Graph2() {
//   const g = {};

//   const edge = (a, b) => {
//     if (!g[a]) {
//       g[a] = [];
//     }

//     g[a].push(b);
//   };
// 	const from = x => g[x];
// 	const to = x => Object.keys(g).map(
//     key => {
//       // vals : [val]
//       const vals = g[key];
//       return [key, vals];
//     }
//   ).filter(([ _, vals ]) => vals.find(y => y === x)).map(([a, _]) => a);

//   return {
// 	  edge,
// 	  from,
// 	  to,
//   };

// }

