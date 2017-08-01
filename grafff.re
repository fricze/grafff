let graph = ref [];

let edge g a => List.append [[a]] g;

graph := edge graph.contents [3, 4];

graph := edge graph.contents [4, 5];

graph := edge graph.contents [5, 9];

graph := edge graph.contents [9, 1];

graph := edge graph.contents [1, 3];

graph := edge graph.contents [5, 8];

let filterFrom x pair =>
  switch pair {
  | [] => false
  | [a, b] => a === x
  | [a, b, ...rest] => false
  };

let filterTo x pair =>
  switch pair {
  | [] => false
  | [a, b] => b === x
  | [a, b, ...rest] => false
  };

let fromVerticle x g =>
  List.filter (filterFrom x) g |> List.map (fun [a, b] => b);

let toVerticle x g =>
  List.filter (filterTo x) g |> List.map (fun [a, b] => a);

let gg = Hashtbl.create;
